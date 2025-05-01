package com.onlineexam.loginlogout.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineexam.loginlogout.model.Exam;
import com.onlineexam.loginlogout.model.User;
import com.onlineexam.loginlogout.model.UserExam;

public interface UserExamRepository extends JpaRepository<UserExam, Long> {
    Optional<UserExam> findByUserAndExam(User user, Exam exam); // ✅ Added
    List<UserExam> findAllByUser(User user);                    // ✅ Added
    List<UserExam> findByUser_Id(Long userId);                  // ✅ Added
}