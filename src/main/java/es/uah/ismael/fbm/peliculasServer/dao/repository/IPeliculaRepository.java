package es.uah.ismael.fbm.peliculasServer.dao.repository;

import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

    Pelicula findByTitulo(String titulo);

    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);

    List<Pelicula> findByAnio(Integer anio);

    List<Pelicula> findByAnioBetween(Integer anio1, Integer anio2);

    List<Pelicula> findByAnioBefore(Integer anio);

    List<Pelicula> findByAnioAfter(Integer anio);

    List<Pelicula> findByGenero(String genero);

    List<Pelicula> findByDireccion(String direccion);

    @Query("SELECT p FROM Pelicula p WHERE :actor MEMBER OF p.actores")
    List<Pelicula> findByActoresContaining(Actor actor);

    //buscar titulo de la pelicula a partir de su id
    @Query("SELECT p.titulo FROM Pelicula p WHERE p.idPelicula = :idPelicula")
    String findTituloById(Integer idPelicula);
}
