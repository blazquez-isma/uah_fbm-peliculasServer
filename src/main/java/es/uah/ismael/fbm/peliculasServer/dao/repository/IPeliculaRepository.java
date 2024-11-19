package es.uah.ismael.fbm.peliculasServer.dao.repository;

import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

    Pelicula findByTitulo(String titulo);

    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);

    List<Pelicula> findByAnio(Integer anio);

    List<Pelicula> findByAnioBetween(Integer anio1, Integer anio2);

    List<Pelicula> findByAnioBefore(Integer anio);

    List<Pelicula> findByAnioAfter(Integer anio);

//    List<Pelicula> findByDuracionGreaterThanEqual(Integer duracion);
//
//    List<Pelicula> findByDuracionLessThanEqual(Integer duracion);

    List<Pelicula> findByGenero(String genero);

    List<Pelicula> findByDireccion(String direccion);

    List<Pelicula> findByActoresContaining(Actor actor);
}
