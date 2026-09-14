package com.cumbrecamp.backend.controller;

import com.cumbrecamp.backend.model.Resena;
import com.cumbrecamp.backend.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resenas")
@CrossOrigin(origins = "*")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping("/alojamiento/{alojamientoId}")
    public List<Resena> listarPorAlojamiento(@PathVariable Long alojamientoId) {
        return resenaService.listarPorAlojamiento(alojamientoId);
    }

    @PostMapping
    public ResponseEntity<?> crearResena(@RequestBody Resena resena) {
        try {
            Resena nuevaResena = resenaService.guardarResena(resena);
            return ResponseEntity.ok(nuevaResena);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}