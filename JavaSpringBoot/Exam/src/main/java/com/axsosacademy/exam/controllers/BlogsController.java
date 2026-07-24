package com.axsosacademy.exam.controllers;

import com.axsosacademy.exam.models.Blog;
import com.axsosacademy.exam.services.BlogService;
import com.axsosacademy.exam.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class BlogController {
    private final BlogService blogService;
    private final UserService userService;
    public BlogController(BlogService blogService, UserService userService) {
        this.blogService = blogService;
        this.userService = userService;
    }
    // Get the logged-in user ID from the session
    private Long currentUserId(HttpSession session) {
        return (Long) session.getAttribute("userId");
    }
// Show all blogs
    @GetMapping("/dashboard")
    public String dashboard(Model model,
    HttpSession session) {

        Long userId = currentUserId(session);

        if (userId == null) {
            return "redirect:/";
        }
        model.addAttribute("loggedUser", userService.findUser(userId));
        model.addAttribute("newProject", new Blog());

        return "dashboard.jsp";
}
    // Create a new project
    @PostMapping("/create")
    public String create(
            @Valid @ModelAttribute("newBlog") Blog blog,
            BindingResult result,
            Model model,
            HttpSession session) {

        Long userId = currentUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        if (result.hasErrors()) {
            model.addAttribute("loggedUser", userService.findUser(userId));
            model.addAttribute("blogs", blogService.allBlogs());

            return "dashboard.jsp";
        }
        blog.setCreator(userService.findUser(userId));
        BlogService.createBlog(blog);

        return "redirect:/dashboard";}

        // Show project details
        @GetMapping("/details/{id}")
        public String details(
                @PathVariable("id") Long id,
                Model model,
                HttpSession session) {

            Long userId = currentUserId(session);

            if (userId == null) {
                return "redirect:/";
            }

            Blog blog = blogService.findBlog(id);

            if (blog == null) {
                return "redirect:/projects";
            }

            model.addAttribute("blog", blog);
            model.addAttribute("loggedUserId", userId);

            return "details.jsp";
        }

    @GetMapping("/edit/{id}")
    public String editPage(
            @PathVariable("id") Long id,
            Model model,
            HttpSession session) {

        Long userId = currentUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Blog blog = blogService.findBlog(id);

        if (blog == null ||
                !blog.getCreator().getId().equals(userId)) {

            return "redirect:/dashboard";
        }

        model.addAttribute("blog", blog);

        return "edit.jsp";
    }
    @DeleteMapping("/details/{id}")
    public String delete(
            @PathVariable("id") Long id,
            HttpSession session) {

        Long userId = currentUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Blog blog = blogService.findBlog(id);

        if (blog != null &&
                blog.getCreator().getId().equals(userId)) {

            blogService.deleteBlog(id);
        }

        return "redirect:/dashboard";
    }


    @GetMapping("/details/{id}/comments")
    public String comments(
            @PathVariable("id") Long id,
            Model model,
            HttpSession session) {

        Long userId = currentUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Blog blog = blogService.findBlog(id);

        if (blog == null ||
                !blog.getCreator().getId().equals(userId)) {

            return "redirect:/dashboard";
        }

        model.addAttribute("blog", blog);

        return "comments.jsp";
    }



/////////////////////////////////

}

