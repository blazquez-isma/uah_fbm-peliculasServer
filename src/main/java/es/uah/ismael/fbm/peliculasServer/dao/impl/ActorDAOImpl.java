package es.uah.ismael.fbm.peliculasServer.dao.impl;

import es.uah.ismael.fbm.peliculasServer.dao.IActorDAO;
import es.uah.ismael.fbm.peliculasServer.dao.repository.IActorRepository;
import es.uah.ismael.fbm.peliculasServer.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ActorDAOImpl implements IActorDAO {

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<Actor> buscarTodos() {
        return actorRepository.findAll();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        return actorRepository.findById(idActor).orElse(null);
    }

    @Override
    public List<Actor> buscarActoresPorIds(List<Integer> ids) {
        return actorRepository.findByIdActorIn(ids);
    }

    @Override
    public Actor buscarActorPorNombreCompleto(String nombreCompleto) {
        return actorRepository.findByNombre(nombreCompleto);
    }

    @Override
    public List<Actor> buscarActoresPorNombre(String nombre) {
        return actorRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Actor> buscarActoresPorFechaNacimientoBetween(LocalDate fecha1, LocalDate fecha2) {
        return actorRepository.findByFechaNacimientoBetween(fecha1, fecha2);
    }

    @Override
    public List<Actor> buscarActoresPorFechaNacimientoBefore(LocalDate fecha) {
        return actorRepository.findByFechaNacimientoBefore(fecha);
    }

    @Override
    public List<Actor> buscarActoresPorFechaNacimientoAfter(LocalDate fecha) {
        return actorRepository.findByFechaNacimientoAfter(fecha);
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
    public List<Actor> buscarActoresPorPelicula(Integer idPelicula) {
        return actorRepository.findAllByPeliculaId(idPelicula);
    }
}
