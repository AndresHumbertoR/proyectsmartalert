package com.example.proyectosmartalert;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.proyectosmartalert.models.Pregunta;
import com.example.proyectosmartalert.utils.PreguntasHelper;
import java.util.List;

public class PreguntaActivity extends AppCompatActivity {

    private List<Pregunta> preguntas;
    private int preguntaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        preguntas = PreguntasHelper.cargarPreguntas(this);
        preguntaActual = getIntent().getIntExtra("numero_pregunta", 1) - 1;

        mostrarPregunta();
    }

    private void mostrarPregunta() {
        Pregunta pregunta = preguntas.get(preguntaActual);

        ImageView imagen = findViewById(R.id.imagenPregunta);
        TextView textoPregunta = findViewById(R.id.textoPregunta);
        RadioGroup opcionesGroup = findViewById(R.id.opcionesGroup);
        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        TextView tvProgreso = findViewById(R.id.tvProgreso);

        imagen.setImageResource(pregunta.getImagenResId());
        textoPregunta.setText(pregunta.getTexto());
        tvProgreso.setText((preguntaActual + 1) + "/" + preguntas.size());

        opcionesGroup.removeAllViews();
        for (String opcion : pregunta.getOpciones()) {
            RadioButton rb = new RadioButton(this);
            rb.setText(opcion);
            rb.setPadding(16, 16, 16, 16);
            opcionesGroup.addView(rb);
        }

        btnSiguiente.setOnClickListener(v -> {
            int selectedId = opcionesGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "¡Selecciona una respuesta!", Toast.LENGTH_SHORT).show();
                return;
            }

            int respuestaIndex = opcionesGroup.indexOfChild(findViewById(selectedId));
            if (respuestaIndex == pregunta.getRespuestaCorrecta()) {
                Toast.makeText(this, "✅ Correcto", Toast.LENGTH_SHORT).show();

                if (preguntaActual < preguntas.size() - 1) {
                    Intent intent = new Intent(this, PreguntaActivity.class);
                    intent.putExtra("numero_pregunta", preguntaActual + 2);
                    startActivity(intent);
                } else {
                    startActivity(new Intent(this, ResultadoActivity.class));
                }
                finish();
            } else {
                Toast.makeText(this, "❌ Incorrecto. Intenta de nuevo", Toast.LENGTH_SHORT).show();
            }
        });
    }

}