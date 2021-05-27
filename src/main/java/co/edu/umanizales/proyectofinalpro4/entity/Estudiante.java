package co.edu.umanizales.proyectofinalpro4.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String documento;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date nacimiento;

    private Integer edad;

    @Column(length = 20, nullable = false)
    private String estado;

    @PrePersist
    public void prePersist() {

        estado = "MATRICULADO";
        createAt = new Date();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Estudiante() {
        super();
    }


}
