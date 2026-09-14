package com.cumbrecamp.backend.controller;

import com.cumbrecamp.backend.model.Alojamiento;
import com.cumbrecamp.backend.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/alojamientos")
@CrossOrigin(origins = "*")
public class AlojamientoController {

    @Autowired
    private AlojamientoService alojamientoService;

    @GetMapping
    public List<Alojamiento> listarAlojamientos() {
        return alojamientoService.listarAlojamientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alojamiento> buscarPorId(@PathVariable Long id) {
        return alojamientoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/destino/{destinoId}")
    public List<Alojamiento> listarPorDestino(@PathVariable Long destinoId) {
        return alojamientoService.listarPorDestino(destinoId);
    }

    @GetMapping("/filtro/tipo")
    public List<Alojamiento> listarPorTipo(@RequestParam String tipo) {
        return alojamientoService.listarPorTipo(tipo);
    }

    @GetMapping("/filtro/precio")
    public List<Alojamiento> filtrarPorPrecio(@RequestParam BigDecimal max) {
        return alojamientoService.filtrarPorPrecioMaximo(max);
    }

    @PostMapping
    public Alojamiento crearAlojamiento(@RequestBody Alojamiento alojamiento) {
        return alojamientoService.guardarAlojamiento(alojamiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlojamiento(@PathVariable Long id) {
        alojamientoService.eliminarAlojamiento(id);
        return ResponseEntity.noContent().build();
    }
}