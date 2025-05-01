package com.onlineexam.loginlogout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineexam.loginlogout.model.Exam;
import com.onlineexam.loginlogout.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByExam(Exam exam);
}