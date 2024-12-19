package es.uah.ismael.fbm.peliculasServer.dao;

import es.uah.ismael.fbm.peliculasServer.model.Pelicula;

import java.util.List;

public interface IPeliculaDAO {

    List<Pelicula> buscarTodas();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    Pelicula buscarPeliculaPorTituloCompleto(String titulo);

    List<Pelicula> buscarPeliculasPorTitulo(String titulo);

    List<Pelicula> buscarPeliculasPorAnioBefore(Integer anio);

    List<Pelicula> buscarPeliculasPorAnioAfter(Integer anio);

    List<Pelicula> buscarPeliculasPorAnioBetween(Integer anio1, Integer anio2);

    List<Pelicula> buscarPeliculasPorGenero(String genero);

    List<Pelicula> buscarPeliculasPorDireccion(String direccion);

    List<Pelicula> buscarPeliculasPorActor(Integer idActor);

    String buscarTituloPeliculaPorId(Integer idPelicula);

    Pelicula guardarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer idPelicula);

    void actualizarPelicula(Pelicula pelicula);

}
