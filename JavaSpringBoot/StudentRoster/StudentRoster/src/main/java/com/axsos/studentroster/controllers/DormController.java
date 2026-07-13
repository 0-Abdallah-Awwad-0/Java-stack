package com.axsos.studentroster.controllers;

import com.axsos.studentroster.models.Dorm;
import com.axsos.studentroster.models.Student;
import com.axsos.studentroster.services.DormService;
import com.axsos.studentroster.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DormController {

    private final DormService dormService;
    private final StudentService studentService;

    public DormController(
            DormService dormService,
            StudentService studentService
    ) {
        this.dormService = dormService;
        this.studentService = studentService;
    }

    @GetMapping("/dorms")
    public String allDorms(Model model) {
        model.addAttribute("dorms", dormService.findAll());
        return "dorms";
    }

    @GetMapping("/dorms/new")
    public String newDorm(Model model) {
        model.addAttribute("dorm", new Dorm());
        return "newDorm";
    }

    @PostMapping("/dorms")
    public String createDorm(
            @Valid @ModelAttribute("dorm") Dorm dorm,
            BindingResult result
    ) {
        Dorm createdDorm = dormService.create(dorm, result);

        if (result.hasErrors()) {
            return "newDorm";
        }

        return "redirect:/dorms/" + createdDorm.getId();
    }

    @GetMapping("/dorms/{id}")
    public String dormDetails(
            @PathVariable("id") Long id,
            Model model
    ) {
        Dorm dorm = dormService.findById(id);

        if (dorm == null) {
            return "redirect:/dorms";
        }

        model.addAttribute("dorm", dorm);

        // Ninja Bonus:
        // Show every student so assigned students can be reassigned.
        model.addAttribute("allStudents", studentService.findAll());

        return "dormDetails";
    }

    @PostMapping("/dorms/{dormId}/students")
    public String addOrReassignStudent(
            @PathVariable("dormId") Long dormId,
            @RequestParam("studentId") Long studentId
    ) {
        Dorm dorm = dormService.findById(dormId);
        Student student = studentService.findById(studentId);

        if (dorm == null || student == null) {
            return "redirect:/dorms";
        }

        // This works for both first assignment and reassignment.
        studentService.assignToDorm(student, dorm);

        return "redirect:/dorms/" + dormId;
    }

    @PostMapping("/dorms/{dormId}/students/{studentId}/remove")
    public String removeStudentFromDorm(
            @PathVariable("dormId") Long dormId,
            @PathVariable("studentId") Long studentId
    ) {
        Dorm dorm = dormService.findById(dormId);
        Student student = studentService.findById(studentId);

        if (dorm == null || student == null) {
            return "redirect:/dorms";
        }

        // Only remove the student when they currently belong to this dorm.
        if (student.getDorm() != null
                && student.getDorm().getId().equals(dormId)) {
            studentService.removeFromDorm(student);
        }

        return "redirect:/dorms/" + dormId;
    }
}
