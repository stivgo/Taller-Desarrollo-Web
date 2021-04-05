package com.desarrollo.taller.servicios.libro;

import com.desarrollo.taller.modelos.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RepositorioLibro {

    public List<Libro> obtenerLibros() throws Exception ;
    public Libro obtenerLibro(Double id) throws Exception ;
    public Libro agregarNuevoLibro(Libro libro) throws Exception ;
    public Libro actualizarLibro(Double id,Libro libro) throws Exception ;
    public List<Libro> obtenerLibrosPorAutor(String nombreAutor, String apellidoAutor) throws  Exception;


}