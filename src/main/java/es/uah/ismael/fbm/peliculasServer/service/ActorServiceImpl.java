package es.uah.ismael.fbm.peliculasServer.service;

import es.uah.ismael.fbm.peliculasServer.dao.IActorDAO;
import es.uah.ismael.fbm.peliculasServer.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    private IActorDAO actorDAO;

    @Override
    public List<Actor> buscarTodos() {
        return actorDAO.buscarTodos();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        return actorDAO.buscarActorPorId(idActor);
    }

    @Override
    public List<Actor> buscarActoresPorNombre(String nombre) {
        return actorDAO.buscarActoresPorNombre(nombre);
    }

    @Override
    public List<Actor> buscarActoresPorPelicula(Integer idPelicula) {
        return actorDAO.buscarActoresPorPelicula(idPelicula);
    }

    @Override
    public void guardarActor(Actor actor) {
        actorDAO.guardarActor(actor);
    }

    @Override
    public void eliminarActor(Integer idActor) {
        actorDAO.eliminarActor(idActor);
    }

    @Override
    public void actualizarActor(Actor actor) {
        actorDAO.actualizarActor(actor);
    }

    @Override
    public void asignarPelicula(Integer idActor, Integer idPelicula) {
        actorDAO.asignarPelicula(idActor, idPelicula);
    }

    @Override
    public void desasignarPelicula(Integer idActor, Integer idPelicula) {
        actorDAO.desasignarPelicula(idActor, idPelicula);
    }
}
