package com.desarrollo.taller.modelos;

public class DetalleLibro {

    private String descripcion;
    private int precio;
    private int year;
    private int numeroPaginas;

    public DetalleLibro(Libro libro){
        this.descripcion = libro.getDescripcion();
        this.precio = libro.getPrecio();
        this.year = libro.getYear();
        this.numeroPaginas = libro.getNumeroPaginas();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getYear() {
        return year;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

}
