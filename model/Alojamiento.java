package model;

import java.math.BigDecimal;

public class Alojamiento {
    private Long id;
    private String nombre;
    private String tipo; // ej. Hotel, Departamento
    private String direccion;
    private int capacidad;
    private BigDecimal precioPorNoche;
    private Destino destino;

    public Alojamiento() {}

    public Alojamiento(Long id, String nombre, String tipo, String direccion, int capacidad, BigDecimal precioPorNoche, Destino destino) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.destino = destino;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public BigDecimal getPrecioPorNoche() { return precioPorNoche; }
    public void setPrecioPorNoche(BigDecimal precioPorNoche) { this.precioPorNoche = precioPorNoche; }
    public Destino getDestino() { return destino; }
    public void setDestino(Destino destino) { this.destino = destino; }

    @Override
    public String toString() {
        return "Alojamiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
