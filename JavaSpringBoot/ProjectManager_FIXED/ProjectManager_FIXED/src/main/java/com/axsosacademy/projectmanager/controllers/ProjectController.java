package com.axsosacademy.projectmanager.controllers;

import com.axsosacademy.projectmanager.models.Project;
import com.axsosacademy.projectmanager.models.User;
import com.axsosacademy.projectmanager.services.ProjectService;
import com.axsosacademy.projectmanager.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User loggedInUser = getLoggedInUser(session);

        if (loggedInUser == null) {
            return "redirect:/";
        }

        model.addAttribute("loggedInUser", loggedInUser);
        model.addAttribute(
                "otherProjects",
                projectService.findOtherProjects(loggedInUser.getId())
        );
        model.addAttribute(
                "myProjects",
                projectService.findMyProjects(loggedInUser.getId())
        );

        return "dashboard";
    }

    @GetMapping("/projects/new")
    public String newProject(HttpSession session, Model model) {
        if (getLoggedInUser(session) == null) {
            return "redirect:/";
        }

        model.addAttribute("project", new Project());

        return "newProject";
    }

    @PostMapping("/projects")
    public String createProject(
            @Valid @ModelAttribute("project") Project project,
            BindingResult result,
            HttpSession session
    ) {
        User loggedInUser = getLoggedInUser(session);

        if (loggedInUser == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            return "newProject";
        }

        project.setLead(loggedInUser);
        projectService.create(project);

        return "redirect:/dashboard";
    }

    @GetMapping("/projects/{id}")
    public String showProject(
            @PathVariable("id") Long id,
            HttpSession session,
            Model model
    ) {
        User loggedInUser = getLoggedInUser(session);

        if (loggedInUser == null) {
            return "redirect:/";
        }

        Project project = projectService.findById(id);

        if (project == null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("project", project);
        model.addAttribute("loggedInUser", loggedInUser);

        return "showProject";
    }

    @GetMapping("/projects/{id}/edit")
    public String editProject(
            @PathVariable("id") Long id,
            HttpSession session,
            Model model
    ) {
        Long userId = getSessionUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Project project = projectService.findById(id);

        if (!projectService.isOwner(project, userId)) {
            return "redirect:/dashboard";
        }

        model.addAttribute("project", project);

        return "editProject";
    }

    @PutMapping("/projects/{id}")
    public String updateProject(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("project") Project formProject,
            BindingResult result,
            HttpSession session
    ) {
        Long userId = getSessionUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Project existingProject = projectService.findById(id);

        if (!projectService.isOwner(existingProject, userId)) {
            return "redirect:/dashboard";
        }

        if (result.hasErrors()) {
            return "editProject";
        }

        projectService.update(existingProject, formProject);

        return "redirect:/projects/" + id;
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProject(
            @PathVariable("id") Long id,
            HttpSession session
    ) {
        Long userId = getSessionUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Project project = projectService.findById(id);

        if (projectService.isOwner(project, userId)) {
            projectService.delete(project);
        }

        return "redirect:/dashboard";
    }

    private Long getSessionUserId(HttpSession session) {
        return (Long) session.getAttribute("userId");
    }

    private User getLoggedInUser(HttpSession session) {
        Long userId = getSessionUserId(session);

        if (userId == null) {
            return null;
        }

        User user = userService.findById(userId);

        if (user == null) {
            session.invalidate();
        }

        return user;
    }
}
