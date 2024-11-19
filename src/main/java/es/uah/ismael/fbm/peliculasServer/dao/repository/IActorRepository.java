package es.uah.ismael.fbm.peliculasServer.dao.repository;

import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    Actor findByNombre(String nombre);

    List<Actor> findByNombreContainingIgnoreCase(String nombre);

//    List<Actor> findByFechaNacimiento(LocalDate fechaNacimiento);
//
//    List<Actor> findByFechaNacimientoBetween(LocalDate fechaNacimiento1, LocalDate fechaNacimiento2);
//
//    List<Actor> findByFechaNacimientoAfter(LocalDate fechaNacimiento);
//
//    List<Actor> findByFechaNacimientoBefore(LocalDate fechaNacimiento);
//
//    List<Actor> findByPaisNacimiento(String paisNacimiento);
//
//    List<Actor> findByPaisNacimientoContainingIgnoreCase(String paisNacimiento);

    List<Actor> findByPeliculasContaining(Pelicula pelicula);

}
