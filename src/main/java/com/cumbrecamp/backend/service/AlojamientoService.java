package com.cumbrecamp.backend.service;

import com.cumbrecamp.backend.model.Alojamiento;
import com.cumbrecamp.backend.repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AlojamientoService {
    @Autowired
    private AlojamientoRepository alojamientoRepository;

    public List<Alojamiento> listarAlojamientos() {
        return alojamientoRepository.findAll();
    }

    public Optional<Alojamiento> buscarPorId(Long id) {
        return alojamientoRepository.findById(id);
    }

    public List<Alojamiento> listarPorDestino(Long destinoId) {
        return alojamientoRepository.findByDestinoId(destinoId);
    }

    public List<Alojamiento> listarPorTipo(String tipo) {
        return alojamientoRepository.findByTipo(tipo);
    }

    public List<Alojamiento> filtrarPorPrecioMaximo(BigDecimal precioMax) {
        return alojamientoRepository.findByPrecioNocheLessThanEqual(precioMax);
    }

    public Alojamiento guardarAlojamiento(Alojamiento alojamiento) {
        return alojamientoRepository.save(alojamiento);
    }

    public void eliminarAlojamiento(Long id) {
        alojamientoRepository.deleteById(id);
    }
}