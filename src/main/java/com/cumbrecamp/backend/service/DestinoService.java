package com.cumbrecamp.backend.service;

import com.cumbrecamp.backend.model.Destino;
import com.cumbrecamp.backend.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DestinoService {
    @Autowired
    private DestinoRepository destinoRepository;

    public List<Destino> listarDestinosActivos() {
        return destinoRepository.findByActivoTrue();
    }

    public List<Destino> listarTodos() {
        return destinoRepository.findAll();
    }

    public Optional<Destino> buscarPorId(Long id) {
        return destinoRepository.findById(id);
    }

    public Destino guardarDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    public void eliminarDestino(Long id) {
        destinoRepository.deleteById(id);
    }
}