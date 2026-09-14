package com.cumbrecamp.backend.service;

import com.cumbrecamp.backend.model.Experiencia;
import com.cumbrecamp.backend.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> listarExperienciasActivas() {
        return experienciaRepository.findByActivoTrue();
    }

    public List<Experiencia> listarTodas() {
        return experienciaRepository.findAll();
    }

    public Optional<Experiencia> buscarPorId(Long id) {
        return experienciaRepository.findById(id);
    }

    public Experiencia guardarExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public void eliminarExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }
}