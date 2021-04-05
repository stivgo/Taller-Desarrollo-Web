package com.desarrollo.taller.controladores;

import com.desarrollo.taller.modelos.DetalleAutor;
import com.desarrollo.taller.modelos.DetalleLibro;
import com.desarrollo.taller.modelos.Libro;
import com.desarrollo.taller.servicios.libro.ServicioLibro;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.desarrollo.taller.TallerApplication.LOGGER;

@RestController
@RequestMapping(value = "/libros")
public class LibroControlador {

    private ServicioLibro servicioLibro;

    @Autowired
    public LibroControlador(ServicioLibro servicioLibro) {
        this.servicioLibro = servicioLibro;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Libro>> obtenerLibros(){
        List<Libro> libros = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            libros = this.servicioLibro.obtenerLibros();
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("LibroControlador.obtenerLibros Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(libros);
    }

    @GetMapping(value = "/{idL}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> obtenerLibro(@PathVariable String idL){
        Double id = Double.parseDouble(idL);
        Libro libro = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            libro = this.servicioLibro.obtenerLibro(id);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("LibroControlador.obtenerLibro Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(libro);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> nuevoLibro(@RequestBody Libro libro) {
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        long id = 0;
        try {
            libro = this.servicioLibro.agregarNuevoLibro(libro);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("ProductController.nuevoAutor Cause: " + e.getMessage());
            libro = null;

        }
        return ResponseEntity.status(codigo).body(libro);
    }

    @PutMapping(value = "/{idL}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Libro> actualizarLibro(@RequestBody Libro libro, @PathVariable String idL) {
        Double id = Double.parseDouble(idL);
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            libro = this.servicioLibro.actualizarLibro(id,libro);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("ProductController.nuevoAutor Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(libro);
    }

    @GetMapping(value = "/autor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DetalleAutor>> buscarLibrosPorAutor(@RequestParam String nombreAutor,
                                                                   @RequestParam String apellidoAutor) {
        List<DetalleAutor> respuesta = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            respuesta = this.servicioLibro.obtenerLibrosPorAutor(nombreAutor, apellidoAutor);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("ProductController.nuevoAutor Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(respuesta);
    }

    @PutMapping(value = "/detalle/{idL}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetalleLibro> detallarLibro(@PathVariable String idL, @RequestBody ObjectNode numeroPaginas) {
        int numeroPaginasInt = numeroPaginas.get("numeroPaginas").asInt();
        Double id = Double.parseDouble(idL);
        DetalleLibro respuesta = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            respuesta = this.servicioLibro.detallarLibro(id, numeroPaginasInt);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("ProductController.nuevoAutor Cause: " + e.getMessage());
            respuesta = null;
        }
        return ResponseEntity.status(codigo).body(respuesta);
    }
}
