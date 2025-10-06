package com.poli.arq.rest.api.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.arq.rest.api.model.Calificacion;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    private Map<Long, Calificacion> calificaciones = new HashMap<>();
    private Long idCounter = 1L;

    @GetMapping
    public Collection<Calificacion> listar() {
        return calificaciones.values();
    }

    @GetMapping("/{id}")
    public Calificacion obtener(@PathVariable Long id) {
        return calificaciones.get(id);
    }

    @PostMapping
    public Calificacion crear(@RequestBody Calificacion calificacion) {
        calificacion.setId(idCounter++);
        calificaciones.put(calificacion.getId(), calificacion);
        return calificacion;
    }

    @PutMapping("/{id}")
    public Calificacion actualizar(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        calificacion.setId(id);
        calificaciones.put(id, calificacion);
        return calificacion;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        calificaciones.remove(id);
    }
}
