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

import com.poli.arq.rest.api.model.Matricula;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private Map<Long, Matricula> matriculas = new HashMap<>();
    private Long idCounter = 1L;

    @GetMapping
    public Collection<Matricula> listar() {
        return matriculas.values();
    }

    @GetMapping("/{id}")
    public Matricula obtener(@PathVariable Long id) {
        return matriculas.get(id);
    }

    @PostMapping
    public Matricula crear(@RequestBody Matricula matricula) {
        matricula.setId(idCounter++);
        matriculas.put(matricula.getId(), matricula);
        return matricula;
    }

    @PutMapping("/{id}")
    public Matricula actualizar(@PathVariable Long id, @RequestBody Matricula matricula) {
        matricula.setId(id);
        matriculas.put(id, matricula);
        return matricula;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        matriculas.remove(id);
    }
}
