package co.edu.umanizales.proyectofinalpro4.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.umanizales.proyectofinalpro4.entity.Docente;
import co.edu.umanizales.proyectofinalpro4.repository.*;

@Service
public class DocenteService implements  IDocenteService{


    @Autowired
    private DocenteDao docenteDao;

    @Override
    public Docente save(Docente docente) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> findAll() {

        return docenteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Docente findById(Long id) {
        return docenteDao.findById(id).orElse(null);
    }

    @Override
    public Page<Docente> filtrado(String documento, String nombre, int page) {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public Page<Docente> findAll(Pageable pegeable) {
        return docenteDao.findAll(pegeable);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        docenteDao.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> findAyudas(Long id) {
        return null;
    }

}
