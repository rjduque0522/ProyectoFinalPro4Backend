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

import co.edu.umanizales.proyectofinalpro4.entity.Salon;
import co.edu.umanizales.proyectofinalpro4.repository.*;

@Service
public class SalonService implements ISalonService {


    @Autowired
    private SalonDao salonDao;

    @Override
    public Salon save(Salon salon) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Salon> findAll() {

        return salonDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Salon findById(Long id) {
        return salonDao.findById(id).orElse(null);
    }

    @Override
    public Page<Salon> filtrado(String nombre, int page) {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public Page<Salon> findAll(Pageable pegeable) {
        return salonDao.findAll(pegeable);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        salonDao.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> findAyudas(Long id) {
        return null;
    }
}
