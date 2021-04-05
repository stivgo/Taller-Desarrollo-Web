package com.desarrollo.taller.modelos;

import java.time.LocalDate;

public class Libro {
    private double id;
    private String titulo;
    private String descripcion;
    private int precio;
    private String nombreAutor;
    private String apellidoAutor;
    private int year;
    private int numeroPaginas;

    public Libro(double id, String titulo, String descripcion, int precio, String nombreAutor,
            String apellidoAutor, int year) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.year = year;
        this.numeroPaginas = 0;
    }

    public double getId() {
        return id;
    }

    public String getTitulo() { return  titulo; }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public int getYear() {
        return year;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public boolean compararLibroPorId(double idOtroLibro){
        return this.id == idOtroLibro;
    }

    public boolean compararLibroPorId(Libro otroLibro){
        return this.id == otroLibro.getId();
    }

    public boolean compararLibroPorAutor(String nombreAutor, String apellidoAutor) {
        return this.nombreAutor.equalsIgnoreCase(nombreAutor)
                && this.apellidoAutor.equalsIgnoreCase(apellidoAutor);
    }

    public void modificarNumeroPaginas(int nuevoNumeroPaginas) throws Exception{
        if ( nuevoNumeroPaginas > 1500 || nuevoNumeroPaginas < 0) {
            throw new Exception("El número de páginas debe ser un número positivo menor a 1500");
        }
        this.numeroPaginas = nuevoNumeroPaginas;
    }

    public void validarInformacion() throws Exception{
        if ( titulo.length() < 5 || titulo.length() > 100 ){
            throw new Exception("El titulo " + titulo + " no tiene entre 5 y 100 caracteres");
        }
        if ( descripcion.length() > 200 ){
            throw new Exception("La descripción " + titulo + " no puede tener más de 200 caracteres");
        }
        if ( precio < 10000 ){
            throw new Exception("El precio " + precio + " no puede ser menor a 10000");
        }
        if ( nombreAutor.equals("") || nombreAutor == null ){
            throw new Exception("El nombre del autor es un campo obligatorio");
        }
        if ( apellidoAutor.equals("") || apellidoAutor == null ){
            throw new Exception("El apellido del autor es un campo obligatorio");
        }
        if ( year > LocalDate.now().getYear() ){
            throw new Exception("El año " + year + " no puede ser mayor al año actual");
        }
        if ( year < 1000 ){
            throw new Exception("El año " + year + " debe tener 4 dígitos");
        }
    }


}
