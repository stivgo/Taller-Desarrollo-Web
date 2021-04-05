package com.desarrollo.taller.modelos;

public class Libro {
    private double id;
    private String descripcion;
    private double precio;
    private Autor autor;
    private int year;

    public Libro(double id, String descripcion, double precio, Autor autor, int year) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.autor = autor;
        this.year = year;
    }

    public double getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getYear() {
        return year;
    }
}
