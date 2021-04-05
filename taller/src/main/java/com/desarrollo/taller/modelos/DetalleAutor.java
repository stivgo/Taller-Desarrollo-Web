package com.desarrollo.taller.modelos;

public class DetalleAutor {
    private String titulo;
    private String nombreAutor;
    private String apellidoAutor;

    public DetalleAutor(Libro libro){
        this.titulo = libro.getTitulo();
        this.nombreAutor = libro.getNombreAutor();
        this.apellidoAutor = libro.getApellidoAutor();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }
}
