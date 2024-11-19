package es.uah.ismael.fbm.peliculasServer.service;

import es.uah.ismael.fbm.peliculasServer.model.Actor;

import java.util.List;

public interface IActorService {

    List<Actor> buscarTodos();

    Actor buscarActorPorId(Integer idActor);

    List<Actor> buscarActoresPorNombre(String nombre);

    List<Actor> buscarActoresPorPelicula(Integer idPelicula);

    void guardarActor(Actor actor);

    void eliminarActor(Integer idActor);

    void actualizarActor(Actor actor);

    void asignarPelicula(Integer idActor, Integer idPelicula);

    void desasignarPelicula(Integer idActor, Integer idPelicula);

}
