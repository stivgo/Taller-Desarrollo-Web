package com.desarrollo.taller.modelos;

public class Autor {
    private double id;
    private String nombre;
    private String apellido;

    public Autor(double id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public double getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
