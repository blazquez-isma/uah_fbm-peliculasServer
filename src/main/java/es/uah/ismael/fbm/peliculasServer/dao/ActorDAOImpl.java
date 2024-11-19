package es.uah.ismael.fbm.peliculasServer.dao;

import es.uah.ismael.fbm.peliculasServer.dao.repository.IActorRepository;
import es.uah.ismael.fbm.peliculasServer.dao.repository.IPeliculaRepository;
import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorDAOImpl implements IActorDAO{

    @Autowired
    private IActorRepository actorRepository;

    @Autowired
    private IPeliculaRepository peliculaRepository;

    @Override
    public List<Actor> buscarTodos() {
        return actorRepository.findAll();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        return actorRepository.findById(idActor).orElse(null);
    }

    @Override
    public List<Actor> buscarActoresPorNombre(String nombre) {
        return actorRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public void guardarActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void eliminarActor(Integer idActor) {
        actorRepository.deleteById(idActor);
    }

    @Override
    public void actualizarActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void asignarPelicula(Integer idActor, Integer idPelicula) {
        Actor actor = actorRepository.findById(idActor).orElse(null);
        if (actor != null) {
            actor.getPeliculas().add(peliculaRepository.findById(idPelicula).orElse(null));
            actorRepository.save(actor);
        }
    }

    @Override
    public void desasignarPelicula(Integer idActor, Integer idPelicula) {
        Actor actor = actorRepository.findById(idActor).orElse(null);
        if (actor != null) {
            actor.getPeliculas().remove(peliculaRepository.findById(idPelicula).orElse(null));
            actorRepository.save(actor);
        }
    }

    @Override
    public List<Actor> buscarActoresPorPelicula(Integer idPelicula) {
        Pelicula pelicula = peliculaRepository.findById(idPelicula).orElse(null);
        return pelicula != null ? actorRepository.findByPeliculasContaining(pelicula) : List.of();
    }
}
