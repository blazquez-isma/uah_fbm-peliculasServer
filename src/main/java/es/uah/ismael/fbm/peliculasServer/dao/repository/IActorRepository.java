package es.uah.ismael.fbm.peliculasServer.dao.repository;

import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findByIdActorIn(List<Integer> idActors);

    Actor findByNombre(String nombre);

    List<Actor> findByNombreContainingIgnoreCase(String nombre);

    List<Actor> findByPeliculasContaining(Pelicula pelicula);

}
