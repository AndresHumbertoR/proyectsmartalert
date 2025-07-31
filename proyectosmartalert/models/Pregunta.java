package com.example.proyectosmartalert.models;

public class Pregunta {
    private final String texto;
    private final int imagenResId;
    private final String[] opciones;
    private final int respuestaCorrecta;

    public Pregunta(String texto, int imagenResId, String[] opciones, int respuestaCorrecta) {
        this.texto = texto;
        this.imagenResId = imagenResId;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getTexto() { return texto; }
    public int getImagenResId() { return imagenResId; }
    public String[] getOpciones() { return opciones; }
    public int getRespuestaCorrecta() { return respuestaCorrecta; }
}