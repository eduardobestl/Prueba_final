package cl.lemagnifique.restaurant.model.persistence.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name ="visita")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="fecha")
    private Date fecha;
    @Column(name="hora")
    private Time hora;
    @Column(name="lugar")
    private String lugar;
    @Column(name="realizado")
    private boolean realizado;
    @Column(name="detalle")
    private String detalle;
    @ManyToOne
    @JoinColumn(name="profesional_id", insertable = true, updatable = false)
    private Profesional profesional;
    @ManyToOne
    @JoinColumn(name = "cliente_id", insertable = true, updatable = false)
    private Cliente cliente;

    public Visita() {
    }

    public Visita(int id, Date fecha, Time hora, String lugar, boolean realizado, String detalle,  Profesional profesional, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.realizado = realizado;
        this.detalle = detalle;
        this.profesional = profesional;
        this.cliente = cliente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
