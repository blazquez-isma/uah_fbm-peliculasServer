package es.uah.ismael.fbm.peliculasServer.service;

import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;

import java.time.LocalDate;
import java.util.List;

public interface IActorService {

    List<Actor> buscarTodos();

    Actor buscarActorPorId(Integer idActor);

    List<Actor> buscarActoresPorIds(List<Integer> ids);

    Actor buscarActorPorNombreCompleto(String nombreCompleto);

    List<Actor> buscarActoresPorNombre(String nombre);

    List<Actor> buscarActoresPorPelicula(Integer idPelicula);

    List<Actor> buscarActoresPorFechaNacimiento(LocalDate fecha1, LocalDate fecha2);

    void guardarActor(Actor actor);

    void eliminarActor(Integer idActor);

    void actualizarActor(Actor actor);

    void asignarPelicula(Integer idActor, Pelicula pelicula);

    void desasignarPelicula(Integer idActor, Pelicula pelicula);

}
