package com.onlineexam.loginlogout.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    private LocalDate dateTaken; // The date the exam was taken

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    // Default constructor sets dateTaken to today
    public UserExam() {
        this.dateTaken = LocalDate.now();
    }

    // Constructor with all fields including custom date
    public UserExam(User user, Exam exam, int score, LocalDate dateTaken) {
        this.user = user;
        this.exam = exam;
        this.score = score;
        this.dateTaken = dateTaken;
    }

    // Constructor with automatic dateTaken = today
    public UserExam(User user, Exam exam, int score) {
        this.user = user;
        this.exam = exam;
        this.score = score;
        this.dateTaken = LocalDate.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public LocalDate getDateTaken() { return dateTaken; }
    public void setDateTaken(LocalDate dateTaken) { this.dateTaken = dateTaken; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Exam getExam() { return exam; }
    public void setExam(Exam exam) { this.exam = exam; }
}
