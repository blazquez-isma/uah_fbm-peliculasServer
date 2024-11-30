package es.uah.ismael.fbm.peliculasServer.controller;

import es.uah.ismael.fbm.peliculasServer.model.Actor;
import es.uah.ismael.fbm.peliculasServer.service.IActorService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private IActorService actorService;

    @GetMapping("/actores")
    public List<Actor> buscarTodos() {
        return actorService.buscarTodos();
    }

    @GetMapping("/actores/{id}")
    public Actor buscarActorPorId(@PathVariable("id") Integer id) {
        return actorService.buscarActorPorId(id);
    }

    @PostMapping("/actores/ids")
    public List<Actor> buscarActoresPorIds(@RequestBody List<Integer> ids) {
        return actorService.buscarActoresPorIds(ids);
    }

    @GetMapping("/actores/nombreCompleto/{nombre}")
    public Actor buscarActorPorNombreCompleto(@PathVariable("nombre") String nombre) {
        return actorService.buscarActorPorNombreCompleto(nombre);
    }

    @GetMapping("/actores/nombre/{nombre}")
    public List<Actor> buscarActoresPorNombre(@PathVariable("nombre") String nombre) {
        return actorService.buscarActoresPorNombre(nombre);
    }

    @GetMapping("/actores/fechaNacimiento/{fecha1}/{fecha2}")
    public List<Actor> buscarActoresPorFechaNacimiento(@PathVariable("fecha1") LocalDate fecha1, @PathVariable("fecha2") LocalDate fecha2) {
        return actorService.buscarActoresPorFechaNacimiento(fecha1, fecha2);
    }

    @GetMapping("/actores/pelicula/{idPelicula}")
    public List<Actor> buscarActoresPorPelicula(@PathVariable("idPelicula") Integer idPelicula) {
        return actorService.buscarActoresPorPelicula(idPelicula);
    }

    @PostMapping("/actores")
    public void guardarActor(@RequestBody Actor actor) {
        actorService.guardarActor(actor);
    }

    @PutMapping("/actores")
    public void actualizarActor(@RequestBody Actor actor) {
        actorService.actualizarActor(actor);
    }

    @DeleteMapping("/actores/{id}")
    public void eliminarActor(@PathVariable("id") Integer id) {
        actorService.eliminarActor(id);
    }

}
