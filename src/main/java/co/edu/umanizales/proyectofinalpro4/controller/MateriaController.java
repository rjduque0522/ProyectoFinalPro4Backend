package co.edu.umanizales.proyectofinalpro4.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.umanizales.proyectofinalpro4.entity.Docente;
import co.edu.umanizales.proyectofinalpro4.entity.Estudiante;
import co.edu.umanizales.proyectofinalpro4.repository.MateriaDao;
import co.edu.umanizales.proyectofinalpro4.service.IDocenteService;
import co.edu.umanizales.proyectofinalpro4.service.IEstudianteService;
import co.edu.umanizales.proyectofinalpro4.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import co.edu.umanizales.proyectofinalpro4.service.IMateriaService;
import co.edu.umanizales.proyectofinalpro4.entity.Materia;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/materia")

public class MateriaController {

    @Autowired
    private IMateriaService materiaService;

    @GetMapping("/all")
    public List<Materia> index() {
        return materiaService.findAll();
    }


    @GetMapping("/filtro/{nombre}/{page}")
    public Page<Materia> Filtrado(@PathVariable String nombre, @PathVariable int page) {

        if (nombre.equals("-")) {
            nombre = "";
        }
        return  materiaService.filtrado(nombre, page);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Materia materia) {
        Materia materiaNew = null;
        Map<String, Object> response = new HashMap<>();
        try {
            materiaNew = materiaService.save(materia);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La materia ha sido creado con éxito");
        response.put("estudiante", materiaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Materia materia, @PathVariable Long id) {
        Materia materiaActual = materiaService.findById(id);
        Materia materiaActualizado = null;

        Map<String, Object> response = new HashMap<>();

        if (materiaActual == null) {
            response.put("mensaje", "La materia ID: "
                    .concat(id.toString().concat(" no existe en la base de datos por tanto no se puede editar")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if (materia.getNombre() != null)
                materiaActual.setNombre(materia.getNombre());

            materiaActualizado = materiaService.save(materiaActualizado);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar la materia en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La materia ha sido actualizada con éxito");
        response.put("materia", materiaActualizado);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            materiaService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar la materia en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La materia ha sido eliminado con éxito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}
