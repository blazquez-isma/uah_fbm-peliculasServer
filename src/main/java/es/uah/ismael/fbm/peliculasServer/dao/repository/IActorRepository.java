package es.uah.ismael.fbm.peliculasServer.dao.repository;

import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findByIdActorIn(List<Integer> idActors);

    Actor findByNombre(String nombre);

    List<Actor> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT a FROM Actor a JOIN a.peliculas p WHERE p.idPelicula = :idPelicula")
    List<Actor> findAllByPeliculaId(Integer idPelicula);

    List<Actor> findByFechaNacimientoBetween(LocalDate fecha1, LocalDate fecha2);

    List<Actor> findByFechaNacimientoBefore(LocalDate fecha);

    List<Actor> findByFechaNacimientoAfter(LocalDate fecha);

}
