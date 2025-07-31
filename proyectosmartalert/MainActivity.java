package com.example.proyectosmartalert;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Verificación explícita del botón
        Button btnCuestionario = findViewById(R.id.btnCuestionario);
        Button btnOtroPrograma = findViewById(R.id.btnOtroPrograma);
        if (btnCuestionario != null) {
            btnCuestionario.setOnClickListener(v -> {
                try {
                    Intent intent1 = new Intent(this, PresentacionActivity.class);
                    startActivity(intent1);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Error al abrir el cuestionario", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Error: Botón no encontrado", Toast.LENGTH_SHORT).show();
        }
        if (btnOtroPrograma != null) {
            btnOtroPrograma.setOnClickListener(v -> {
                try {
                    Intent intent2 = new Intent(this, smartstopwatch.class);
                    startActivity(intent2);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Error al abrir program", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
}