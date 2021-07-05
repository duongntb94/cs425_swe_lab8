package com.tbdnguyen.eregistrar.controller;

import com.tbdnguyen.eregistrar.model.Student;
import com.tbdnguyen.eregistrar.service.StudentService;
import com.tbdnguyen.eregistrar.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public ModelAndView getHomePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student/index");
        List<Student> students = studentService.getAllStudents();
        mav.addObject("students", students);
        return mav;
    }

    @PostMapping(value = "/students/find")
    public ModelAndView getSearchPage(@Valid @ModelAttribute("keyword") String keyword,
                                      BindingResult bindingResult, Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student/index");
        List<Student> students = studentService.findStudentsByStudentNumber(keyword);
        mav.addObject("students", students);
        return mav;
    }

    @GetMapping(value = "/students/create")
    public String getCreateStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping(value = "/students/create")
    public String createNewStudent(@Valid @ModelAttribute("student") Student student,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/create";
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping(value = "/students/edit/{studentId}")
    public String getEditStudent(@PathVariable Long studentId, Model model) {
        if (studentId == null) {
            return "student/index";
        }
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        }
        return "student/index";
    }

    @PostMapping(value = "/students/edit/{studentId}")
    public String editNewStudent(@Valid @ModelAttribute("student") Student student,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping(value = "/students/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
}
