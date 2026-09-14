package com.cumbrecamp.backend.service;

import com.cumbrecamp.backend.model.Resena;
import com.cumbrecamp.backend.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResenaService {
    @Autowired
    private ResenaRepository resenaRepository;

    public List<Resena> listarPorAlojamiento(Long alojamientoId) {
        return resenaRepository.findByAlojamientoId(alojamientoId);
    }

    public Resena guardarResena(Resena resena) {
        if (resena.getCalificacion() < 1 || resena.getCalificacion() > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5 estrellas.");
        }
        return resenaRepository.save(resena);
    }
}