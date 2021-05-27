package co.edu.umanizales.proyectofinalpro4.service;

import java.util.*;

import co.edu.umanizales.proyectofinalpro4.entity.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMateriaService {

    public Materia save(Materia materia);

    public List<Materia> findAll();

    public Page<Materia> findAll(Pageable pageable);

    public Materia findById(Long id);

    public Page<Materia> filtrado( String nombre, int page);

    public void delete(Long id);

    public List<Map<String, Object>> findAyudas(Long id);
}
