package com.onlineexam.loginlogout.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onlineexam.loginlogout.model.Exam;
import com.onlineexam.loginlogout.model.Question;
import com.onlineexam.loginlogout.model.User;
import com.onlineexam.loginlogout.model.UserExam;
import com.onlineexam.loginlogout.repository.ExamRepository;
import com.onlineexam.loginlogout.repository.QuestionRepository;
import com.onlineexam.loginlogout.repository.UserExamRepository;
import com.onlineexam.loginlogout.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserExamRepository userExamRepository;

    @PostConstruct
    public void init() {
        Optional<User> optionalUser = userRepository.findByUsername("student1");
        User user = optionalUser.orElseGet(() -> userRepository.save(new User("student1", "password")));

        Exam exam = examRepository.findByTitle("Cybersecurity Basics")
                .orElseGet(() -> examRepository.save(new Exam("Cybersecurity Basics")));

        if (questionRepository.findAllByExam(exam).isEmpty()) {
            Question q1 = new Question("What is a firewall?", "Virus", "Antivirus", "Security System", "None", "Security System", exam);
            Question q2 = new Question("What is phishing?", "Fishing scam", "Online scam", "Fake email trick", "Hacking site", "Fake email trick", exam);
            questionRepository.saveAll(Arrays.asList(q1, q2));
        }

        if (userExamRepository.findByUserAndExam(user, exam).isEmpty()) {
            UserExam userExam = new UserExam(user, exam, 2, LocalDate.now());
            userExamRepository.save(userExam);
        }
    }
}
