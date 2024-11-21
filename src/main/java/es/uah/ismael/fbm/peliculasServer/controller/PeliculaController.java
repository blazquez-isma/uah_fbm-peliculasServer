package es.uah.ismael.fbm.peliculasServer.controller;

import es.uah.ismael.fbm.peliculasServer.model.Pelicula;
import es.uah.ismael.fbm.peliculasServer.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {

    @Autowired
    private IPeliculaService peliculaService;

    @GetMapping("/peliculas")
    public List<Pelicula> buscarTodos() {
        return peliculaService.buscarTodas();
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula buscarPeliculaPorId(@PathVariable("id") Integer id) {
        return peliculaService.buscarPeliculaPorId(id);
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> buscarPeliculasPorTitulo(@PathVariable("titulo") String titulo) {
        return peliculaService.buscarPeliculasPorTitulo(titulo);
    }

    @GetMapping("/peliculas/genero/{genero}")
    public List<Pelicula> buscarPeliculasPorGenero(@PathVariable("genero") String genero) {
        return peliculaService.buscarPeliculasPorGenero(genero);
    }

    @GetMapping("/peliculas/direccion/{direccion}")
    public List<Pelicula> buscarPeliculasPorDireccion(@PathVariable("direccion") String direccion) {
        return peliculaService.buscarPeliculasPorDireccion(direccion);
    }

    @GetMapping("/peliculas/anio/{anio1}/{anio2}")
    public List<Pelicula> buscarPeliculasPorAnio(@PathVariable("anio1") Integer anio1, @PathVariable("anio2") Integer anio2) {
        return peliculaService.buscarPeliculasPorAnio(anio1, anio2);
    }

    @GetMapping("/peliculas/actor/{idActor}")
    public List<Pelicula> buscarPeliculasPorActor(@PathVariable("idActor") Integer idActor) {
        return peliculaService.buscarPeliculasPorActor(idActor);
    }

    @PostMapping("/peliculas")
    public void guardarPelicula(@RequestBody Pelicula pelicula) {
        peliculaService.guardarPelicula(pelicula);
    }

    @PutMapping("/peliculas")
    public void actualizarPelicula(@RequestBody Pelicula pelicula) {
        peliculaService.actualizarPelicula(pelicula);
    }

    @DeleteMapping("/peliculas/{id}")
    public void eliminarPelicula(@PathVariable("id") Integer id) {
        peliculaService.eliminarPelicula(id);
    }

    @GetMapping("/peliculas/asignar/{idPelicula}/{idActor}")
    public void asignarActor(@PathVariable("idPelicula") Integer idPelicula, @PathVariable("idActor") Integer idActor) {
        peliculaService.asignarActor(idPelicula, idActor);
    }

    @GetMapping("/peliculas/desasignar/{idPelicula}/{idActor}")
    public void desasignarActor(@PathVariable("idPelicula") Integer idPelicula, @PathVariable("idActor") Integer idActor) {
        peliculaService.desasignarActor(idPelicula, idActor);
    }

}
