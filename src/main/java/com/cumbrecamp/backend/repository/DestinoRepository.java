package com.cumbrecamp.backend.repository;

import com.cumbrecamp.backend.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {
    List<Destino> findByActivoTrue();
    List<Destino> findByDepartamentoContainingIgnoreCase(String departamento);
}