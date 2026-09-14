package model;

import java.math.BigDecimal;

public class Experiencia {
    private Long id;
    private String titulo;
    private String descripcion;
    private Destino destino;
    private BigDecimal precio;

    public Experiencia() {}

    public Experiencia(Long id, String titulo, String descripcion, Destino destino, BigDecimal precio) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.destino = destino;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Destino getDestino() { return destino; }
    public void setDestino(Destino destino) { this.destino = destino; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Experiencia{" + "id=" + id + ", titulo='" + titulo + '\'' + '}';
    }
}
