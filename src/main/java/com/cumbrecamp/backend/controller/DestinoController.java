package com.cumbrecamp.backend.controller;

import com.cumbrecamp.backend.model.Destino;
import com.cumbrecamp.backend.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/destinos")
@CrossOrigin(origins = "*")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public List<Destino> listarDestinos() {
        return destinoService.listarDestinosActivos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarPorId(@PathVariable Long id) {
        return destinoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Destino crearDestino(@RequestBody Destino destino) {
        return destinoService.guardarDestino(destino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDestino(@PathVariable Long id) {
        destinoService.eliminarDestino(id);
        return ResponseEntity.noContent().build();
    }
}