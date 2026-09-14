package model;

import java.math.BigDecimal;

public class Destino {
    private Long id;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private BigDecimal tarifaPromedio;

    public Destino() {}

    public Destino(Long id, String nombre, String descripcion, String ubicacion, BigDecimal tarifaPromedio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.tarifaPromedio = tarifaPromedio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public BigDecimal getTarifaPromedio() { return tarifaPromedio; }
    public void setTarifaPromedio(BigDecimal tarifaPromedio) { this.tarifaPromedio = tarifaPromedio; }

    @Override
    public String toString() {
        return "Destino{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
