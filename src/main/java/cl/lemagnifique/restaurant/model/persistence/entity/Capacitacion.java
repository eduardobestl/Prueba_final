package cl.lemagnifique.restaurant.model.persistence.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="capacitacion")
public class Capacitacion {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="id")
      private int id;
      @Column(name="nombre")
      private String nombre;
      @Column(name="lugar")
      private String lugar;
      @Column(name="fecha")
      private Date fecha;
      @Column(name="hora")
      private Time hora;
      @Column(name="detalle")
      private String detalle;
      @Column(name="duracion")
      private float duracion;
      @Column(name="cantidad")
      private int cantidad;
      @ManyToOne
      @JoinColumn(name = "cliente_id", insertable = true, updatable = false)
      private Cliente cliente;

    public Capacitacion() {
    }

  public Capacitacion(int id, String nombre, String lugar, Date fecha, Time hora, String detalle, float duracion, int cantidad, Cliente cliente) {
    this.id = id;
    this.nombre = nombre;
    this.lugar = lugar;
    this.fecha = fecha;
    this.hora = hora;
    this.detalle = detalle;
    this.duracion = duracion;
    this.cantidad = cantidad;
    this.cliente = cliente;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
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

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public float getDuracion() {
    return duracion;
  }

  public void setDuracion(float duracion) {
    this.duracion = duracion;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
