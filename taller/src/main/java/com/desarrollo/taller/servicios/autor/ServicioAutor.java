package com.desarrollo.taller.servicios.autor;

import com.desarrollo.taller.modelos.Autor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ServicioAutor {
    public List<Autor> obtenerAutores() throws Exception;
    public Autor obtenerAutor(Double id) throws Exception;
    public Autor nuevoAutor(Autor autor) throws Exception;

}
