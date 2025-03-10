package com.example.tallerdetecciondaltonismo.models;

import java.util.List;

public class ColorQuestion {
    private String color;
    private List<String> options;

    public ColorQuestion(String color, List<String> options) {
        this.color = color;
        this.options = options;
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
}
