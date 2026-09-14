package model;

import java.time.LocalDate;

public class Resena {
    private Long id;
    private Cliente cliente;
    private Integer calificacion; // 1-5
    private String comentario;
    private LocalDate fecha;
    private Experiencia experiencia;

    public Resena() {}

    public Resena(Long id, Cliente cliente, Integer calificacion, String comentario, LocalDate fecha, Experiencia experiencia) {
        this.id = id;
        this.cliente = cliente;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = fecha;
        this.experiencia = experiencia;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Integer getCalificacion() { return calificacion; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Experiencia getExperiencia() { return experiencia; }
    public void setExperiencia(Experiencia experiencia) { this.experiencia = experiencia; }

    @Override
    public String toString() {
        return "Resena{" + "id=" + id + ", calificacion=" + calificacion + '}';
    }
}
