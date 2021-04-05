package com.desarrollo.taller.servicios.libro;

import com.desarrollo.taller.modelos.Libro;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioLibroImple implements ServicioLibro{
    @Override
    public List<Libro> obtenerLibros() throws Exception {
        return null;
    }

    @Override
    public Libro obtenerLibro(Double id) throws Exception {
        return null;
    }

    @Override
    public Libro nuevoLibro(Libro libro) throws Exception {
        return null;
    }

    @Override
    public Libro actualizarLibro(Double id,Libro libro) throws Exception {
        return null;
    }
}
