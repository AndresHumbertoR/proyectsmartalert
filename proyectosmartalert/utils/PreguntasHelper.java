package com.example.proyectosmartalert.utils;

import android.content.Context;

import com.example.proyectosmartalert.R;
import com.example.proyectosmartalert.models.Pregunta;
import java.util.ArrayList;
import java.util.List;

public class PreguntasHelper {
    public static List<Pregunta> cargarPreguntas(Context context) {
        List<Pregunta> preguntas = new ArrayList<>();

        // Preguntas generales
        preguntas.add(new Pregunta(
                "¿Cuántas estaciones tiene el año?",
                R.drawable.general,
                new String[]{"2", "4", "6", "12"},
                1
        ));

        preguntas.add(new Pregunta(
                "Si en Argentina es verano, ¿qué estación es en México?",
                R.drawable.general,
                new String[]{"Primavera", "Verano", "Otoño", "Invierno"},
                3
        ));

        // Primavera
        preguntas.add(new Pregunta(
                "Las plantas y árboles ______ y ______ en primavera.",
                R.drawable.primavera,
                new String[]{"Hielan / duermen", "Florecen / crecen", "Secan / caen", "Vuelan / corren"},
                1
        ));

        preguntas.add(new Pregunta(
                "¿Qué fenómeno meteorológico es común en primavera?",
                R.drawable.primavera,
                new String[]{"Nevadas", "Lluvias", "Sequías extremas", "Huracanes"},
                1
        ));

        // Verano
        preguntas.add(new Pregunta(
                "¿Cuál es la estación más calurosa?",
                R.drawable.verano,
                new String[]{"Primavera", "Verano", "Otoño", "Invierno"},
                1
        ));

        preguntas.add(new Pregunta(
                "¿Qué frutas son de temporada en verano?",
                R.drawable.verano,
                new String[]{"Manzanas", "Uvas", "Sandía", "Calabazas"},
                2
        ));

        // Otoño
        preguntas.add(new Pregunta(
                "¿Qué les pasa a las hojas en otoño?",
                R.drawable.otono,
                new String[]{"Se vuelven azules", "Cambian de color", "Crecen más", "Brillan"},
                1
        ));

        preguntas.add(new Pregunta(
                "Festividad típica de otoño:",
                R.drawable.otono,
                new String[]{"Navidad", "Halloween", "Pascua", "Día de la Madre"},
                1
        ));

        // Invierno
        preguntas.add(new Pregunta(
                "¿En qué meses ocurre el invierno?",
                R.drawable.invierno,
                new String[]{"Mar-Abr-May", "Jun-Jul-Ago", "Sep-Oct-Nov", "Dic-Ene-Feb"},
                3
        ));

        preguntas.add(new Pregunta(
                "Si en México es invierno, ¿qué estación es en Argentina?",
                R.drawable.invierno,
                new String[]{"Primavera", "Verano", "Otoño", "Invierno"},
                1
        ));

        return preguntas;
    }
}