package es.uah.ismael.fbm.peliculasServer.dao;

import es.uah.ismael.fbm.peliculasServer.dao.repository.IActorRepository;
import es.uah.ismael.fbm.peliculasServer.dao.repository.IPeliculaRepository;
import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeliculaDAOImpl implements IPeliculaDAO{

    @Autowired
    private IPeliculaRepository peliculapeliculaRepository;

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculapeliculaRepository.findAll();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        return peliculapeliculaRepository.findById(idPelicula).orElse(null);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        return peliculapeliculaRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnio(Integer anio) {
        return peliculapeliculaRepository.findByAnio(anio);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnioBefore(Integer anio) {
        return peliculapeliculaRepository.findByAnioBefore(anio);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnioAfter(Integer anio) {
        return peliculapeliculaRepository.findByAnioAfter(anio);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnioBetween(Integer anio1, Integer anio2) {
        return peliculapeliculaRepository.findByAnioBetween(anio1, anio2);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorGenero(String genero) {
        return peliculapeliculaRepository.findByGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorDireccion(String direccion) {
        return peliculapeliculaRepository.findByDireccion(direccion);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorActor(Integer idActor) {
        Actor actor = actorRepository.findById(idActor).orElse(null);
        return actor != null ? peliculapeliculaRepository.findByActoresContaining(actor) : List.of();
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculapeliculaRepository.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculapeliculaRepository.findById(idPelicula).ifPresent(pelicula -> {
            pelicula.getActores().forEach(actor -> actor.getPeliculas().remove(pelicula));
            peliculapeliculaRepository.deleteById(pelicula.getIdPelicula());
        });
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculapeliculaRepository.save(pelicula);
    }

    @Override
    public void asignarActor(Integer idPelicula, Integer idActor) {
        Pelicula pelicula = peliculapeliculaRepository.findById(idPelicula).orElse(null);
        Actor actor = actorRepository.findById(idActor).orElse(null);
        if (pelicula != null && actor != null) {
            pelicula.addActor(actor);
            peliculapeliculaRepository.save(pelicula);
        }
    }

    @Override
    public void desasignarActor(Integer idPelicula, Integer idActor) {
        Pelicula pelicula = peliculapeliculaRepository.findById(idPelicula).orElse(null);
        Actor actor = actorRepository.findById(idActor).orElse(null);
        if (pelicula != null && actor != null) {
            pelicula.removeActor(actor);
            peliculapeliculaRepository.save(pelicula);
        }
    }

}
