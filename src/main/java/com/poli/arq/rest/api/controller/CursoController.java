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

import com.poli.arq.rest.api.model.Curso;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private Map<Long, Curso> cursos = new HashMap<>();
    private Long idCounter = 1L;

    @GetMapping
    public Collection<Curso> listar() {
        return cursos.values();
    }

    @GetMapping("/{id}")
    public Curso obtener(@PathVariable Long id) {
        return cursos.get(id);
    }

    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        curso.setId(idCounter++);
        cursos.put(curso.getId(), curso);
        return curso;
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Long id, @RequestBody Curso curso) {
        curso.setId(id);
        cursos.put(id, curso);
        return curso;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cursos.remove(id);
    }
}
