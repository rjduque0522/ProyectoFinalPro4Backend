package co.edu.umanizales.proyectofinalpro4.service;

import co.edu.umanizales.proyectofinalpro4.entity.Materia;
import co.edu.umanizales.proyectofinalpro4.repository.MateriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MateriaService implements IMateriaService{

    @Autowired
    private MateriaDao materiaDao;

    @Override
    public Materia save(Materia materia) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Materia> findAll() {

        return materiaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Materia findById(Long id) {

        return materiaDao.findById(id).orElse(null);
    }

    @Override
    public Page<Materia> filtrado(String nombre, int page) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Materia> findAll(Pageable pegeable) {

        return materiaDao.findAll(pegeable);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        materiaDao.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> findAyudas(Long id) {
        return null;
    }
}
