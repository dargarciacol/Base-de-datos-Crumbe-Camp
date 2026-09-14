package com.cumbrecamp.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "alojamientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destino_id", nullable = false)
    private Destino destino;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String tipo; // Domo, Cabaña, Tienda de Lujo, Suite

    @Column(nullable = false)
    private Integer capacidad;

    @Column(name = "precio_noche", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioNoche;

    @Column(name = "calificacion_promedio")
    private Double calificacionPromedio = 5.0;

    @Column(columnDefinition = "TEXT")
    private String caracteristicas;

    @ElementCollection
    @CollectionTable(name = "alojamiento_amenidades", joinColumns = @JoinColumn(name = "alojamiento_id"))
    @Column(name = "amenidad")
    private List<String> amenidades;

    @Column(nullable = false, length = 30)
    private String estado = "DISPONIBLE"; // DISPONIBLE, OCUPADO, MANTENIMIENTO

    @Column(name = "imagen_url")
    private String imagenUrl;

    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "alojamiento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resena> resenas;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}