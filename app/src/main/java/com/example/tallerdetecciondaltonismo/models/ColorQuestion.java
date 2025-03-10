package com.example.tallerdetecciondaltonismo.models;

import java.util.List;

public class ColorQuestion {
    private String color;
    private List<String> options;
    private String category;
    private String correctAnswer;


    public ColorQuestion(String color,
                         List<String> options,
                         String category,
                         String correctAnswer) {
        this.color = color;
        this.options = options;
        this.category = category;
        this.correctAnswer = correctAnswer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
