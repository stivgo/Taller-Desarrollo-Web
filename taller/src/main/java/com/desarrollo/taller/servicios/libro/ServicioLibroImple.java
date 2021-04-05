package com.desarrollo.taller.servicios.libro;

import com.desarrollo.taller.modelos.DetalleAutor;
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
    public List<DetalleAutor> obtenerLibrosPorAutor(String nombreAutor, String apellidoAutor) throws  Exception{
        return this.repositorioLibro.obtenerLibrosPorAutor(nombreAutor, apellidoAutor);
    }

    @Override
    public DetalleLibro detallarLibro(double idLibro, int numeroPaginas) throws  Exception{
        Libro libroDetallado = obtenerLibro( idLibro );
        libroDetallado.modificarNumeroPaginas(numeroPaginas);
        actualizarLibro(libroDetallado.getId(), libroDetallado);
        DetalleLibro detallesLibro = new DetalleLibro( libroDetallado );
        return  detallesLibro;

    }


}
