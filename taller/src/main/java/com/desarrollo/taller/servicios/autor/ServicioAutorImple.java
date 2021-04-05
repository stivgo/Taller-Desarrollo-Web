package com.desarrollo.taller.servicios.autor;

import com.desarrollo.taller.modelos.Autor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.desarrollo.taller.TallerApplication.LOGGER;

@Service
public class ServicioAutorImple implements ServicioAutor{
    private List<Autor> autores;

    public ServicioAutorImple() {
        this.autores = new ArrayList<Autor>();
        Autor autor = new Autor(1,"Dan","Brown");
        this.autores.add(autor);
        autor = new Autor(2,"Mario","Mendoza");
        this.autores.add(autor);
        autor = new Autor(3,"Gabriel","Garcia");
        this.autores.add(autor);
    }

    @Override
    public List<Autor> obtenerAutores() throws Exception {
        return this.autores;
    }

    @Override
    public Autor obtenerAutor(Double id) throws Exception {

        Autor autor = null;
        for(int i = 0; i<this.autores.size();i++){
            if(this.autores.get(i).getId() == id){
                autor = this.autores.get(i);
            }
        }
        return autor;
    }

    @Override
    public Autor nuevoAutor(Autor autor) throws Exception {
        this.autores.add(autor);
        return autor;
    }
}
