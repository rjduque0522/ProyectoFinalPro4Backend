package co.edu.umanizales.proyectofinalpro4.entity;
import javax.persistence.*;

@Entity
@Table(name="materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2)
    private String nombre;

    public Materia(Long id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia() {
        super();    }
}
