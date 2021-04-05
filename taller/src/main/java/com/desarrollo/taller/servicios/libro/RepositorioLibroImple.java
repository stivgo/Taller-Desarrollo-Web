package com.desarrollo.taller.servicios.libro;

import com.desarrollo.taller.modelos.DetalleAutor;
import com.desarrollo.taller.modelos.DetalleLibro;
import com.desarrollo.taller.modelos.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositorioLibroImple implements RepositorioLibro{

    private List<Libro> libros;

    public RepositorioLibroImple(){
        this.libros = new ArrayList<>();
        this.crearEjemplosPrueba();
    }

    //Este método esta únicamente para simular unos datos de prueba como si se usara una BD
    private void crearEjemplosPrueba(){
        try {
            agregarNuevoLibro(new Libro( 1, "Cien años de soledad","Cien años de Soledad ganó un nobel",
                    450000, "Gabriel", "Garcia", 1967));
            agregarNuevoLibro(new Libro( 2, "El otoño del patriarca", "Habla del otoño de un patriarca", 20000,
                    "Gabriel", "Garcia", 1975));
            agregarNuevoLibro(new Libro( 3, "Vivir para contarla", "Este libro no ganó un nobel", 35000,
                    "Gabriel", "Garcia", 2002));
            agregarNuevoLibro(new Libro( 4, "Satanas", "No es un libro satanico", 100000,
                    "Mario", "Mendoza", 2002));
            agregarNuevoLibro(new Libro( 5, "Scorpio City", "Tampoco es un libro de escorpiones", 65000,
                    "Mario", "Mendoza", 2004));
            agregarNuevoLibro(new Libro( 6, "El Cuervo", "El protagonista no es un cuervo", 17000,
                    "Edgar", "Allan Poe", 1845));
        }
        catch (Exception e){}
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

    public List<DetalleAutor> obtenerLibrosPorAutor(String nombreAutor, String apellidoAutor) throws  Exception{
        List<DetalleAutor> librosPorAutor = new ArrayList<>();
        for(int i=0; i<libros.size(); i++){
            if ( libros.get(i).compararLibroPorAutor(nombreAutor, apellidoAutor) ) {
                librosPorAutor.add( new DetalleAutor(libros.get(i)));
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
