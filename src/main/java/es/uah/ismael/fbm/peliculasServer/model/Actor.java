package es.uah.ismael.fbm.peliculasServer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actores")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActor", nullable = false)
    private Integer idActor;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "pais_nacimiento", length = 100)
    private String paisNacimiento;

    @ManyToMany
    @JoinTable(name = "peliculas_actores",
            joinColumns = {@JoinColumn(name = "idActor", referencedColumnName = "idActor")},
            inverseJoinColumns = {@JoinColumn(name = "idPelicula", referencedColumnName = "idPelicula")})
    @JsonIgnoreProperties("actores")
    private Set<Pelicula> peliculas = new LinkedHashSet<>();

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer id) {
        this.idActor = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public void addPelicula(Pelicula pelicula) {
        if (pelicula != null) {
            getPeliculas().add(pelicula);
            pelicula.getActores().add(this);
        }
    }

    public void removePelicula(Pelicula pelicula) {
        if (pelicula != null) {
            getPeliculas().remove(pelicula);
            pelicula.getActores().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return idActor.equals(actor.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idActor);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "idActor=" + idActor +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", paisNacimiento='" + paisNacimiento + '\'' +
//                ", peliculas=" + peliculas +
                '}';
    }
}