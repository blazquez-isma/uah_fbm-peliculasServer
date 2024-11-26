package es.uah.ismael.fbm.peliculasServer.dao;

import es.uah.ismael.fbm.peliculasServer.model.Actor;

import java.util.List;

public interface IActorDAO {

    List<Actor> buscarTodos();

    Actor buscarActorPorId(Integer idActor);

    List<Actor> buscarActoresPorIds(List<Integer> ids);

    Actor buscarActorPorNombreCompleto(String nombre);

    List<Actor> buscarActoresPorNombre(String nombre);

    void guardarActor(Actor actor);

    void eliminarActor(Integer idActor);

    void actualizarActor(Actor actor);

    void asignarPelicula(Integer idActor, Integer idPelicula);

    void desasignarPelicula(Integer idActor, Integer idPelicula);

    List<Actor> buscarActoresPorPelicula(Integer idPelicula);

}
