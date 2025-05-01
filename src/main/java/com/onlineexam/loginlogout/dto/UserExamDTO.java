package com.onlineexam.loginlogout.dto;

public class UserExamDTO {
    private int percentage;
    private String examDate;

    public UserExamDTO(int percentage, String examDate) {
        this.percentage = percentage;
        this.examDate = examDate;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }
}