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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final DormService dormService;

    public StudentController(
            StudentService studentService,
            DormService dormService
    ) {
        this.studentService = studentService;
        this.dormService = dormService;
    }

    @GetMapping("/students/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("dorms", dormService.findAll());

        return "newStudent";
    }

    @PostMapping("/students")
    public String createStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            @RequestParam(
                    value = "dormId",
                    required = false
            ) Long dormId,
            Model model
    ) {
        Dorm dorm = null;

        if (dormId != null) {
            dorm = dormService.findById(dormId);

            if (dorm == null) {
                result.reject(
                        "InvalidDorm",
                        "The selected dorm does not exist."
                );
            }
        }

        if (result.hasErrors()) {
            // Reload dropdown data after every invalid submission.
            model.addAttribute("dorms", dormService.findAll());
            return "newStudent";
        }

        student.setDorm(dorm);
        Student createdStudent = studentService.create(student);

        if (createdStudent.getDorm() != null) {
            return "redirect:/dorms/" + createdStudent.getDorm().getId();
        }

        return "redirect:/students";
    }

    @GetMapping("/students")
    public String allStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }
}
