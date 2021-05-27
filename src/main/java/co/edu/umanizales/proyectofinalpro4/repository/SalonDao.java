package co.edu.umanizales.proyectofinalpro4.repository;
import co.edu.umanizales.proyectofinalpro4.entity.Docente;
import co.edu.umanizales.proyectofinalpro4.entity.Estudiante;
import co.edu.umanizales.proyectofinalpro4.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface SalonDao  extends JpaRepository<Salon, Long> {
    @Query(value="SELECT e.* FROM salon e INNER JOIN estudiantes t " +
            "ON e.estudiante = t.id INNER  JOIN docente d ON e.docente = d.id"
            + "WHERE e.nombre ilike %:nombre%  ", nativeQuery = true)
    List<Map<String, Object>> salonFiltro(@Param("nombre") String nombre);
}
