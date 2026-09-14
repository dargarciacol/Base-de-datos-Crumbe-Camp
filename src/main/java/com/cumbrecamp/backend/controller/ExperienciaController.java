package com.cumbrecamp.backend.controller;

import com.cumbrecamp.backend.model.Experiencia;
import com.cumbrecamp.backend.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/experiencias")
@CrossOrigin(origins = "*")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping
    public List<Experiencia> listarExperiencias() {
        return experienciaService.listarExperienciasActivas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> buscarPorId(@PathVariable Long id) {
        return experienciaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Experiencia crearExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaService.guardarExperiencia(experiencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarExperiencia(@PathVariable Long id) {
        experienciaService.eliminarExperiencia(id);
        return ResponseEntity.noContent().build();
    }
}