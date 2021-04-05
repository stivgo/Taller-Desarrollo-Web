package com.desarrollo.taller.servicios.libro;

import com.desarrollo.taller.modelos.DetalleLibro;
import com.desarrollo.taller.modelos.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioLibroImple implements ServicioLibro {

    private RepositorioLibro repositorioLibro;

    @Autowired
    public ServicioLibroImple(RepositorioLibro repositorioLibro){
        this.repositorioLibro = repositorioLibro;
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
        return this.repositorioLibro.obtenerLibros();
    }

    @Override
    public Libro obtenerLibro(Double id) throws Exception {
        return this.repositorioLibro.obtenerLibro(id);
    }

    @Override
    public Libro agregarNuevoLibro(Libro libro) throws Exception {
        libro.validarInformacion();
        return this.repositorioLibro.agregarNuevoLibro(libro);

    }

    @Override
    public Libro actualizarLibro(Double id,Libro libro) throws Exception {
        libro.validarInformacion();
        if ( !libro.compararLibroPorId(id) ){
            throw new Exception("El id que solicita cambiar no corresponde con el id del objeto que " +
                    "intenta cambiar");
        }
        return this.repositorioLibro.actualizarLibro(id, libro);
    }

    @Override
    public List<Libro> obtenerLibrosPorAutor(String nombreAutor, String apellidoAutor) throws  Exception{
        return this.repositorioLibro.obtenerLibrosPorAutor(nombreAutor, apellidoAutor);
    }

    @Override
    public DetalleLibro detallarLibro(Libro libro, int numeroPaginas) throws  Exception{
        Libro libroDetallado = obtenerLibro( libro.getId() );
        libroDetallado.modificarNumeroPaginas(numeroPaginas);
        actualizarLibro(libroDetallado.getId(), libroDetallado);
        DetalleLibro detallesLibro = new DetalleLibro( libroDetallado );
        return  detallesLibro;

    }


}
