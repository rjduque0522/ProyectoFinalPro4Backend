package co.edu.umanizales.proyectofinalpro4.entity;

import javax.persistence.*;
import co.edu.umanizales.proyectofinalpro4.entity.Docente;
import co.edu.umanizales.proyectofinalpro4.entity.Estudiante;

@Entity
@Table(name="salon")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2)
    private String nombre;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="FK_salon_docente"), nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="FK_salon_estudiante"), nullable = false)
    private Estudiante estudiante;

    public Salon() {
        super();
    }

    public Salon(Long id, String nombre, Docente docente, Estudiante estudiante) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.docente = docente;
        this.estudiante = estudiante;

    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String salon) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
