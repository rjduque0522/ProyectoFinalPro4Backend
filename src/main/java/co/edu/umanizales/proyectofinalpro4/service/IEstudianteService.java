package co.edu.umanizales.proyectofinalpro4.service;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import co.edu.umanizales.proyectofinalpro4.entity.Estudiante;

public interface IEstudianteService {


        public Estudiante save(Estudiante estudiante);

        public List<Estudiante> findAll();


        public Page<Estudiante> findAll(Pageable pegeable);

        public List<Estudiante> porGrupo(Long grupo);

        public Page<Estudiante> porGrupoPage(Long grupo, int page);

        public Estudiante findById(Long id);

        public Integer calcularEdad(Estudiante estudiante);

        public Page<Estudiante> filtrado( String nombre, String id, int page);

        public void delete(Long id);

        public List<Map<String, Object>> findAyudas(Long id);

    }

