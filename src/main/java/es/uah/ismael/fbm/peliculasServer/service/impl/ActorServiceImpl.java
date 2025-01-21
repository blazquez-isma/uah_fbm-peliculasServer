package es.uah.ismael.fbm.peliculasServer.service.impl;

import es.uah.ismael.fbm.peliculasServer.dao.IActorDAO;
import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import es.uah.ismael.fbm.peliculasServer.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<Actor> buscarActoresPorIds(List<Integer> ids) {
        return actorDAO.buscarActoresPorIds(ids);
    }

    @Override
    public Actor buscarActorPorNombreCompleto(String nombreCompleto) {
        return actorDAO.buscarActorPorNombreCompleto(nombreCompleto);
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
    public List<Actor> buscarActoresPorFechaNacimiento(LocalDate fecha1, LocalDate fecha2){
        if ((fecha1 == null || fecha1.equals(LocalDate.MIN)) && (fecha2 == null || fecha2.equals(LocalDate.MAX))) {
            return actorDAO.buscarTodos();
        }
        if (fecha1 == null || fecha1.equals(LocalDate.MIN)) {
            return actorDAO.buscarActoresPorFechaNacimientoBefore(fecha2);
        }
        if (fecha2 == null || fecha2.equals(LocalDate.MAX)) {
            return actorDAO.buscarActoresPorFechaNacimientoAfter(fecha1);
        }
        return actorDAO.buscarActoresPorFechaNacimientoBetween(fecha1, fecha2);
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
    public void asignarPelicula(Integer idActor, Pelicula pelicula) {
        Actor actorUpdate = buscarActorPorId(idActor);
        actorUpdate.getPeliculas().add(pelicula);
        actualizarActor(actorUpdate);
    }

    @Override
    public void desasignarPelicula(Integer idActor, Pelicula pelicula) {
        Actor actorUpdate = this.buscarActorPorId(idActor);
        actorUpdate.getPeliculas().remove(pelicula);
        actualizarActor(actorUpdate);
    }
}
