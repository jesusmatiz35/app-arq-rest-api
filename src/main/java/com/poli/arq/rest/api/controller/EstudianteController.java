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

import com.poli.arq.rest.api.model.Estudiante;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private Map<Long, Estudiante> estudiantes = new HashMap<>();
    private Long idCounter = 1L;

    @GetMapping
    public Collection<Estudiante> listar() {
        return estudiantes.values();
    }

    @GetMapping("/{id}")
    public Estudiante obtener(@PathVariable Long id) {
        return estudiantes.get(id);
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        estudiante.setId(idCounter++);
        estudiantes.put(estudiante.getId(), estudiante);
        return estudiante;
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        estudiantes.put(id, estudiante);
        return estudiante;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estudiantes.remove(id);
    }
}
