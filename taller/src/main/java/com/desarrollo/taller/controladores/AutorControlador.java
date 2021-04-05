package com.desarrollo.taller.controladores;

import com.desarrollo.taller.modelos.Autor;
import com.desarrollo.taller.servicios.autor.ServicioAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.desarrollo.taller.TallerApplication.LOGGER;
import java.util.List;

@RestController
@RequestMapping(value = "/autores")
public class AutorControlador {
    private ServicioAutor servicioAutor;

    @Autowired
    public AutorControlador(ServicioAutor servicioAutor) {
        this.servicioAutor = servicioAutor;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Autor>> obtenerAutores(){
        List<Autor> autores = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            autores = this.servicioAutor.obtenerAutores();
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("AutorControlador.obtenerAutores Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(autores);
    }

    @GetMapping(value = "/{idA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> obtenerAutor(@PathVariable String idA){
        Double id = Double.parseDouble(idA);
        Autor autor = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            autor = this.servicioAutor.obtenerAutor(id);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("AutorControlador.obtenerAutor Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(autor);

    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> nuevoAutor(@RequestBody Autor autor) {
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            autor = this.servicioAutor.nuevoAutor(autor);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("ProductController.nuevoAutor Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(autor);
    }
}
