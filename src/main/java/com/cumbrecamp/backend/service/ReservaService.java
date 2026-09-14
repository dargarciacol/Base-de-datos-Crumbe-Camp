package com.cumbrecamp.backend.service;

import com.cumbrecamp.backend.model.Reserva;
import com.cumbrecamp.backend.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public List<Reserva> listarPorCliente(Long clienteId) {
        return reservaRepository.findByClienteId(clienteId);
    }

    public List<Reserva> listarPorAlojamiento(Long alojamientoId) {
        return reservaRepository.findByAlojamientoId(alojamientoId);
    }

    public Reserva crearReserva(Reserva reserva) {
        // Validaciones básicas de fechas
        if (reserva.getFechaInicio().isAfter(reserva.getFechaFin()) || reserva.getFechaInicio().isEqual(reserva.getFechaFin())) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha fin.");
        }
        return reservaRepository.save(reserva);
    }

    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setEstadoReserva("CANCELADA");
        reservaRepository.save(reserva);
    }
}