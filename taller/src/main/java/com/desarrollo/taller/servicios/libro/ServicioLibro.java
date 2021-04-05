package com.desarrollo.taller.servicios.libro;

import com.desarrollo.taller.modelos.Autor;
import com.desarrollo.taller.modelos.Libro;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ServicioLibro {
    public List<Libro> obtenerLibros() throws Exception;
    public Libro obtenerLibro(Double id) throws Exception;
    public Libro nuevoLibro(Libro libro) throws Exception;
    public Libro actualizarLibro(Double id,Libro libro) throws Exception;
}
