package co.edu.umanizales.proyectofinalpro4.service;

import co.edu.umanizales.proyectofinalpro4.entity.Salon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ISalonService {

    public Salon save(Salon salon);

    public List<Salon> findAll();

    public Page<Salon> findAll(Pageable pageable);

    public Salon findById(Long id);

    public Page<Salon> filtrado(  String nombre, int page);

    public void delete(Long id);

    public List<Map<String, Object>> findAyudas(Long id);
}
