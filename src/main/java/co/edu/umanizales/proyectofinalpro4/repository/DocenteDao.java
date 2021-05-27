package co.edu.umanizales.proyectofinalpro4.repository;

import java.util.List;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.umanizales.proyectofinalpro4.entity.Docente;

public interface DocenteDao extends JpaRepository<Docente, Long> {



    @Query(value="SELECT e.* FROM docente e INNER JOIN materia m on e.materia = m.id " +
            "WHERE e.documento ilike %:documento% and  e.nombre ilike %:nombre% ", nativeQuery = true)
    List<Docente> docenteFiltro(@Param("nombre") String documento,@Param("documento") String nombre);


}
