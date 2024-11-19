package es.uah.ismael.fbm.peliculasServer.service;

import es.uah.ismael.fbm.peliculasServer.dao.IPeliculaDAO;
import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    IPeliculaDAO peliculaDAO;

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculaDAO.buscarTodas();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        return peliculaDAO.buscarPeliculaPorId(idPelicula);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        return peliculaDAO.buscarPeliculasPorTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorAnio(Integer anio1, Integer anio2) {
        if (anio1 == null && anio2 == null) {
            return peliculaDAO.buscarTodas();
        }
        if (anio1 == null) {
            return peliculaDAO.buscarPeliculasPorAnioBefore(anio2);
        }
        if (anio2 == null) {
            return peliculaDAO.buscarPeliculasPorAnioAfter(anio1);
        }
        return peliculaDAO.buscarPeliculasPorAnioBetween(anio1, anio2);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorGenero(String genero) {
        return peliculaDAO.buscarPeliculasPorGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorDireccion(String direccion) {
        return peliculaDAO.buscarPeliculasPorDireccion(direccion);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorActor(Integer idActor) {
        return peliculaDAO.buscarPeliculasPorActor(idActor);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculaDAO.guardarPelicula(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculaDAO.eliminarPelicula(idPelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculaDAO.actualizarPelicula(pelicula);
    }

    @Override
    public void asignarActor(Integer idPelicula, Integer idActor) {
        peliculaDAO.asignarActor(idPelicula, idActor);
    }

    @Override
    public void desasignarActor(Integer idPelicula, Integer idActor) {
        peliculaDAO.desasignarActor(idPelicula, idActor);
    }
}
