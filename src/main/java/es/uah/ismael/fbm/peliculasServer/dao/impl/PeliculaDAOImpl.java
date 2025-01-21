package es.uah.ismael.fbm.peliculasServer.dao.impl;

import es.uah.ismael.fbm.peliculasServer.dao.IPeliculaDAO;
import es.uah.ismael.fbm.peliculasServer.dao.repository.IActorRepository;
import es.uah.ismael.fbm.peliculasServer.dao.repository.IPeliculaRepository;
import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeliculaDAOImpl implements IPeliculaDAO {

    @Autowired
    private IPeliculaRepository peliculaRepository;

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        return peliculaRepository.findById(idPelicula).orElse(null);
    }

    @Override
    public Pelicula buscarPeliculaPorTituloCompleto(String titulo) {
        return peliculaRepository.findByTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        return peliculaRepository.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnioBefore(Integer anio) {
        return peliculaRepository.findByAnioBefore(anio);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnioAfter(Integer anio) {
        return peliculaRepository.findByAnioAfter(anio);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnioBetween(Integer anio1, Integer anio2) {
        return peliculaRepository.findByAnioBetween(anio1, anio2);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorGenero(String genero) {
        return peliculaRepository.findByGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorDireccion(String direccion) {
        return peliculaRepository.findByDireccion(direccion);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorActor(Integer idActor) {
        Actor actor = actorRepository.findById(idActor).orElse(null);
        return actor != null ? peliculaRepository.findByActoresContaining(actor) : List.of();
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculaRepository.findById(idPelicula).ifPresent(pelicula -> {
            pelicula.getActores().forEach(actor -> actor.getPeliculas().remove(pelicula));
            peliculaRepository.deleteById(pelicula.getIdPelicula());
        });
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public String buscarTituloPeliculaPorId(Integer idPelicula) {
        return peliculaRepository.findTituloById(idPelicula);
    }
}
