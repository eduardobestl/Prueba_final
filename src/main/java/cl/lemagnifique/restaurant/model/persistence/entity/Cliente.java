package cl.lemagnifique.restaurant.model.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;

  @Column(name="rut")
  private String rut;

  @Column(name="nombre")
  private String nombre;

  @Column(name="apellido")
  private String apellido;

  @Column(name="correo")
  private String correo;

  @Column(name="telefono")
  private String telefono;

  @Column(name="afp")
  private String afp;

  @Column(name="sistema_salud")
  private String sistemaSalud;

  @Column(name="direccion")
  private String direccion;

  @Column(name="comuna")
  private String comuna;

  @Column(name="edad")
  private int edad;

  @Column(name="usuario_id")
  private int usuarioId;

  public Cliente() {
  }

  public Cliente(int id, String rut, String nombre, String apellido, String correo, String telefono, String afp, String sistemaSalud, String direccion, String comuna, int edad, int usuarioId) {
    this.id = id;
    this.rut = rut;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.telefono = telefono;
    this.afp = afp;
    this.sistemaSalud = sistemaSalud;
    this.direccion = direccion;
    this.comuna = comuna;
    this.edad = edad;
    this.usuarioId = usuarioId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRut() {
    return rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getAfp() {
    return afp;
  }

  public void setAfp(String afp) {
    this.afp = afp;
  }

  public String getSistemaSalud() {
    return sistemaSalud;
  }

  public void setSistemaSalud(String sistemaSalud) {
    this.sistemaSalud = sistemaSalud;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getComuna() {
    return comuna;
  }

  public void setComuna(String comuna) {
    this.comuna = comuna;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public int getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(int usuarioId) {
    this.usuarioId = usuarioId;
  }
}
