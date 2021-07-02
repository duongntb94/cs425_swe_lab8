package com.tbdnguyen.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author duong at 7/2/21
 * @project eRegistrar
 */
@Controller
public class StudentController {
    @GetMapping("/students")
    public String getHomePage() {
        return "student/index.html";
    }
}
