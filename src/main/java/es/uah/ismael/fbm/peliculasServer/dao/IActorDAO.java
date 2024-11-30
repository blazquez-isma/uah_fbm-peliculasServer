package es.uah.ismael.fbm.peliculasServer.dao;

import es.uah.ismael.fbm.peliculasServer.model.Actor;

import java.time.LocalDate;
import java.util.List;

public interface IActorDAO {

    List<Actor> buscarTodos();

    Actor buscarActorPorId(Integer idActor);

    List<Actor> buscarActoresPorIds(List<Integer> ids);

    Actor buscarActorPorNombreCompleto(String nombre);

    List<Actor> buscarActoresPorNombre(String nombre);

    List<Actor> buscarActoresPorFechaNacimientoBetween(LocalDate fecha1, LocalDate fecha2);

    List<Actor> buscarActoresPorFechaNacimientoBefore(LocalDate fecha);

    List<Actor> buscarActoresPorFechaNacimientoAfter(LocalDate fecha);

    void guardarActor(Actor actor);

    void eliminarActor(Integer idActor);

    void actualizarActor(Actor actor);

    List<Actor> buscarActoresPorPelicula(Integer idPelicula);

}
