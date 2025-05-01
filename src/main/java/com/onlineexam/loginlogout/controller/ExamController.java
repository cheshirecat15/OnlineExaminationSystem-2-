package com.onlineexam.loginlogout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineexam.loginlogout.model.Exam;
import com.onlineexam.loginlogout.model.User;
import com.onlineexam.loginlogout.model.UserExam;
import com.onlineexam.loginlogout.repository.ExamRepository;
import com.onlineexam.loginlogout.repository.UserExamRepository;
import com.onlineexam.loginlogout.repository.UserRepository;

@Controller
@RequestMapping("/api")
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private UserExamRepository userExamRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/exams")
    public String getAllExams(Model model) {
        List<Exam> exams = examRepository.findAll();
        model.addAttribute("exams", exams);
        return "exams";
    }

    @GetMapping("/previous-records")
    public String getPreviousRecords(@RequestParam Long userId, Model model) {
        List<UserExam> userExams = userExamRepository.findByUser_Id(userId); // ✅ Fixed
        model.addAttribute("userExams", userExams);
        return "previous-records";
    }

    @PostMapping("/login")
public String login(@RequestParam String username, @RequestParam String password, Model model) {
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (user.getPassword().equals(password)) {
        model.addAttribute("username", username);
        return "dashboard";
    }

    return "redirect:";
}

    @GetMapping("/")
    public String showLoginPage() {
        return "index";
    }
}
