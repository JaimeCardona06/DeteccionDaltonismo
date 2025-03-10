package com.example.tallerdetecciondaltonismo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Results extends AppCompatActivity {
    private HashMap<String, Integer> scoreByCategory;
    private String category;
    private int score;
    private TextView txtProtanomalia;
    private TextView txtDeuteranomalia;
    private TextView txtTritanomalia;
    private TextView txtAcromatopsia;
    private TextView txtPercentage;
    private TextView txtAnalysis;
    private TextView txtRecommendation;
    private LinkedList<TextView> txtTexts = new LinkedList<>();
    private int index = 0;
    private int totalScore;
    private int totalQuestions = 24;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_results);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();

        txtTexts.add(txtProtanomalia);
        txtTexts.add(txtDeuteranomalia);
        txtTexts.add(txtTritanomalia);
        txtTexts.add(txtAcromatopsia);

        scoreByCategory = (HashMap<String, Integer>) getIntent().getSerializableExtra("scoreByCategory");

        if (scoreByCategory != null) {
            mostrarResultados();
            mostrarAnalisis();
        }
    }

    public void initView(){
        txtProtanomalia = findViewById(R.id.txtProtanomalia);
        txtDeuteranomalia = findViewById(R.id.txtDeuteranomalia);
        txtTritanomalia = findViewById(R.id.txtTritanomalia);
        txtAcromatopsia = findViewById(R.id.txtAcromatopsia);
        txtPercentage = findViewById(R.id.txtPercentage);
        txtAnalysis = findViewById(R.id.txtAnalysis);
        txtRecommendation = findViewById(R.id.txtRecommendation);
    }

    private void mostrarResultados() {
        for (Map.Entry<String, Integer> entry : scoreByCategory.entrySet()) {
            category = entry.getKey();
            int score = entry.getValue();

            totalScore += score;

            if (index < txtTexts.size()) {
                TextView textView = txtTexts.get(index);
                String originalText = textView.getText().toString();
                textView.setText(originalText + " " + category + ": " + score);
                index++;
            }

            Log.d("Results", category + ": " + score);
        }

        int percentage = (totalScore * 100) / totalQuestions;
        txtPercentage.setText("Precisión: " + percentage + "%");

    }

    private void mostrarAnalisis() {
        StringBuilder analysis = new StringBuilder("Análisis de errores:\n");

        if (obtenerPuntajePorCategoria("Rojo-Verde") > 5) {
            analysis.append("Posible daltonismo rojo-verde (Protanomalía/Protanopía)\n");
        }
        if (obtenerPuntajePorCategoria("Azul-Amarillo") > 5) {
            analysis.append("Posible daltonismo azul-amarillo (Tritanomalía/Tritanopía)\n");
        }
        if (obtenerPuntajePorCategoria("Daltonismo Total") > 5) {
            analysis.append("Posible acromatopsia (ausencia total de percepción de color)\n");
        }

        txtAnalysis.setText(analysis.toString());

        if (analysis.toString().contains("Posible")) {
            txtRecommendation.setText("Se recomienda consulta con un especialista para un diagnóstico preciso.");
        } else {
            txtRecommendation.setText("No se detectaron patrones claros de daltonismo.");
        }
    }

    public int obtenerPuntajePorCategoria(String categoria) {
        int score = 0;
        if (scoreByCategory != null && scoreByCategory.containsKey(categoria)) {
            score = scoreByCategory.get(categoria);
            Log.d("Results", "Puntaje de " + categoria + ": " + score);
        } else {
            Log.d("Results", "No hay puntaje para la categoría: " + categoria);
        }

        return score;
    }

}