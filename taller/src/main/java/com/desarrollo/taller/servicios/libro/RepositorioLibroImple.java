package com.desarrollo.taller.servicios.libro;

import com.desarrollo.taller.modelos.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositorioLibroImple implements RepositorioLibro{

    private List<Libro> libros;

    public RepositorioLibroImple(){
        this.libros = new ArrayList<>();
    }

    @Override
    public List<Libro> obtenerLibros() throws Exception {
        return this.libros;
    }

    @Override
    public Libro obtenerLibro(Double id) throws Exception {
        int posicionLibroBuscado = obtenerPosicionLibroEnLista(id);
        if ( posicionLibroBuscado == -1 ){
            throw new Exception("El libro con id " + id + " no existe en el sistema");
        }
        return this.libros.get(posicionLibroBuscado);
    }

    public Libro agregarNuevoLibro(Libro libro) throws Exception {
        int posicionLibroBuscado = obtenerPosicionLibroEnLista( libro );
        if ( posicionLibroBuscado != -1 ){
            throw new Exception("El libro con id " + libro.getId() + " ya existe en el sistema");
        }
        this.libros.add(libro);
        return libro;
    }

    @Override
    public Libro actualizarLibro(Double id, Libro libro) throws Exception {
        int posicionLibroBuscado = obtenerPosicionLibroEnLista(id);
        if ( posicionLibroBuscado == -1 ){
            throw new Exception("El libro con id " + id + " no existe en el sistema");
        }
        this.libros.set(posicionLibroBuscado, libro);
        return libro;
    }

    public List<Libro> obtenerLibrosPorAutor(String nombreAutor, String apellidoAutor) throws  Exception{
        List<Libro> librosPorAutor = new ArrayList<>();
        for(int i=0; i<libros.size(); i++){
            if ( libros.get(i).compararLibroPorAutor(nombreAutor, apellidoAutor) ) {
                librosPorAutor.add(libros.get(i));
            }
        }
        return librosPorAutor;
    }

    private int obtenerPosicionLibroEnLista(double idLibro){
        for(int i=0; i<libros.size(); i++){
            if ( libros.get(i).compararLibroPorId(idLibro) ){
                return i;
            }
        }
        return -1;
    }

    private int obtenerPosicionLibroEnLista(Libro libro){
        for(int i=0; i<libros.size(); i++){
            if ( libros.get(i).compararLibroPorId(libro) ){
                return i;
            }
        }
        return -1;
    }

}
