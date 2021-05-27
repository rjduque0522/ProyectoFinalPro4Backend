package co.edu.umanizales.proyectofinalpro4.repository;

import co.edu.umanizales.proyectofinalpro4.entity.Docente;
import co.edu.umanizales.proyectofinalpro4.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.umanizales.proyectofinalpro4.entity.Materia;

import java.util.List;

public interface MateriaDao  extends JpaRepository<Materia, Long> {
    @Query(value="SELECT e.* FROM materia e " +
            "WHERE e.nombre ilike %:nombre%  ", nativeQuery = true)
    List<Materia> salonFiltro(@Param("nombre") String nombre);
}
