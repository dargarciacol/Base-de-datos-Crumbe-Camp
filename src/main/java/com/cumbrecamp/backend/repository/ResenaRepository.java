package com.cumbrecamp.backend.repository;

import com.cumbrecamp.backend.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {
    List<Resena> findByAlojamientoId(Long alojamientoId);
    List<Resena> findByClienteId(Long clienteId);
}