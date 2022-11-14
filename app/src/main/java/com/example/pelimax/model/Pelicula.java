package com.example.pelimax.model;

public class Pelicula {
    String fecha,genero,sipnosis,titulo,time;
    public Pelicula(String fecha,String genero,String sipnosis,String titulo){
        this.fecha =fecha;
        this.genero =genero;
        this.sipnosis =sipnosis;
        this.titulo =titulo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
