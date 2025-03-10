package com.example.tallerdetecciondaltonismo;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tallerdetecciondaltonismo.models.ColorQuestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Evaluation extends AppCompatActivity {
    private String color;
    private Button btnOpt1;
    private Button btnOpt2;
    private Button btnOpt3;
    private Button btnOpt4;
    private Button btnNext;
    private LinearLayout lytColor;
    private int index = 0;
    private List<ColorQuestion> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_evaluation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
        makeQuestions();
        Actions();
    }

    public void initView(){
        btnOpt1 = findViewById(R.id.btnOpt1);
        btnOpt2 = findViewById(R.id.btnOpt2);
        btnOpt3 = findViewById(R.id.btnOpt3);
        btnOpt4 = findViewById(R.id.btnOpt4);
        btnNext = findViewById(R.id.btnNext);
        lytColor = findViewById(R.id.lytColor);
    }

    public void makeQuestions(){

        data.add(new ColorQuestion ("#FF0000", Arrays.asList(
                getString(R.string.option_red),
                getString(R.string.option_green),
                getString(R.string.option_brown),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#C80000", Arrays.asList(
                getString(R.string.option_red),
                getString(R.string.option_green),
                getString(R.string.option_brown),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#960000", Arrays.asList(
                getString(R.string.option_red),
                getString(R.string.option_green),
                getString(R.string.option_brown),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#960000", Arrays.asList(
                getString(R.string.option_red),
                getString(R.string.option_green),
                getString(R.string.option_brown),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#00FF00", Arrays.asList(
                getString(R.string.option_green),
                getString(R.string.option_red),
                getString(R.string.option_brown),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#00C800", Arrays.asList(
                getString(R.string.option_green),
                getString(R.string.option_red),
                getString(R.string.option_brown),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#009600", Arrays.asList(
                getString(R.string.option_green),
                getString(R.string.option_red),
                getString(R.string.option_brown),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#FFFF00", Arrays.asList(
                getString(R.string.option_yellow),
                getString(R.string.option_green),
                getString(R.string.option_brown),
                getString(R.string.option_white)
        )));

        data.add(new ColorQuestion ("#C8C800", Arrays.asList(
                getString(R.string.option_yellow),
                getString(R.string.option_green),
                getString(R.string.option_brown),
                getString(R.string.option_white)
        )));

        data.add(new ColorQuestion ("#969600", Arrays.asList(
                getString(R.string.option_yellow),
                getString(R.string.option_green),
                getString(R.string.option_brown),
                getString(R.string.option_white)
        )));

        data.add(new ColorQuestion ("#8B4513", Arrays.asList(
                getString(R.string.option_brown),
                getString(R.string.option_red),
                getString(R.string.option_green),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#783214", Arrays.asList(
                getString(R.string.option_brown),
                getString(R.string.option_red),
                getString(R.string.option_green),
                getString(R.string.option_yellow)
        )));

        data.add(new ColorQuestion ("#642805", Arrays.asList(
                getString(R.string.option_brown),
                getString(R.string.option_red),
                getString(R.string.option_green),
                getString(R.string.option_yellow)
        )));


        //Evaluación Azul ↔ Amarillo (Daltonismo Azul-Amarillo)

        data.add(new ColorQuestion ("#0000FF", Arrays.asList(
                getString(R.string.option_blue),
                getString(R.string.option_violet),
                getString(R.string.option_green),
                getString(R.string.option_black)
        )));

        data.add(new ColorQuestion ("#0000C8", Arrays.asList(
                getString(R.string.option_blue),
                getString(R.string.option_violet),
                getString(R.string.option_green),
                getString(R.string.option_black)
        )));

        data.add(new ColorQuestion ("#000096", Arrays.asList(
                getString(R.string.option_blue),
                getString(R.string.option_violet),
                getString(R.string.option_green),
                getString(R.string.option_black)
        )));

        data.add(new ColorQuestion ("#FFFF00", Arrays.asList(
                getString(R.string.option_yellow),
                getString(R.string.option_green),
                getString(R.string.option_white),
                getString(R.string.option_red)
        )));

        data.add(new ColorQuestion ("#C8C800", Arrays.asList(
                getString(R.string.option_yellow),
                getString(R.string.option_green),
                getString(R.string.option_white),
                getString(R.string.option_red)
        )));

        data.add(new ColorQuestion ("#969600", Arrays.asList(
                getString(R.string.option_yellow),
                getString(R.string.option_green),
                getString(R.string.option_white),
                getString(R.string.option_red)
        )));

        //Evaluación de Percepción General (Daltonismo Total)

        data.add(new ColorQuestion ("#FFFFFF", Arrays.asList(
                getString(R.string.option_white),
                getString(R.string.option_yellow),
                getString(R.string.option_gray),
                getString(R.string.option_blue)
        )));

        data.add(new ColorQuestion ("#C8C8C8", Arrays.asList(
                getString(R.string.option_white),
                getString(R.string.option_yellow),
                getString(R.string.option_gray),
                getString(R.string.option_blue)
        )));

        data.add(new ColorQuestion ("#969696", Arrays.asList(
                getString(R.string.option_white),
                getString(R.string.option_yellow),
                getString(R.string.option_gray),
                getString(R.string.option_blue)
        )));

        data.add(new ColorQuestion ("#000000", Arrays.asList(
                getString(R.string.option_black),
                getString(R.string.option_blue),
                getString(R.string.option_gray),
                getString(R.string.option_brown)
        )));

        data.add(new ColorQuestion ("#323232", Arrays.asList(
                getString(R.string.option_black),
                getString(R.string.option_blue),
                getString(R.string.option_gray),
                getString(R.string.option_brown)
        )));

        data.add(new ColorQuestion ("#646464", Arrays.asList(
                getString(R.string.option_black),
                getString(R.string.option_blue),
                getString(R.string.option_gray),
                getString(R.string.option_brown)
        )));

        ColorQuestion firtsQuestion = data.get(0);
        lytColor.setBackgroundColor(Color.parseColor(firtsQuestion.getColor()));
        btnOpt1.setText(firtsQuestion.getOptions().get(0));
        btnOpt2.setText(firtsQuestion.getOptions().get(1));
        btnOpt3.setText(firtsQuestion.getOptions().get(2));
        btnOpt4.setText(firtsQuestion.getOptions().get(3));

    }

    public void Actions(){

        btnNext.setOnClickListener(view -> {
            index++;
            ColorQuestion question = data.get(index);
            updateButtons(question);
        });


    }

    public void updateButtons(ColorQuestion question){
        lytColor.setBackgroundColor(Color.parseColor(question.getColor()));
        btnOpt1.setText(question.getOptions().get(0));
        btnOpt2.setText(question.getOptions().get(1));
        btnOpt3.setText(question.getOptions().get(2));
        btnOpt4.setText(question.getOptions().get(3));
    }

}