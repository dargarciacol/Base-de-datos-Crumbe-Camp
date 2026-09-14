package com.cumbrecamp.backend.repository;

import com.cumbrecamp.backend.model.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Long> {
    List<Alojamiento> findByDestinoId(Long destinoId);
    List<Alojamiento> findByTipo(String tipo);
    List<Alojamiento> findByCapacidadGreaterThanEqual(Integer capacidad);
    List<Alojamiento> findByPrecioNocheLessThanEqual(BigDecimal precioMaximo);
}