package co.edu.umanizales.proyectofinalpro4.service;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import co.edu.umanizales.proyectofinalpro4.entity.Docente;
public interface IDocenteService {


    public Docente save(Docente docente);

    public List<Docente> findAll();

    public Page<Docente> findAll(Pageable pageable);

    public Docente findById(Long id);

    public Page<Docente> filtrado( String id, String nombre, int page);

    public void delete(Long id);

    public List<Map<String, Object>> findAyudas(Long id);
}
