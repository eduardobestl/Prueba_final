package cl.lemagnifique.restaurant.model.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="administrativo")
public class Administrativo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;

  @Column(name="run")
  private String run;

  @Column(name="nombre")
  private String nombre;

  @Column(name="apellido")
  private String apellido;

  @Column(name="correo")
  private String correo;

  @Column(name="area")
  private String area;

  @Column(name="usuario_id")
  private int usuarioId;

  public Administrativo() {
  }

  public Administrativo(int id, String run, String nombre, String apellido,
                        String correo, String area, int usuarioId) {
    this.id = id;
    this.run = run;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.area = area;
    this.usuarioId = usuarioId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRun() {
    return run;
  }

  public void setRun(String run) {
    this.run = run;
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

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public int getUsuarioId() {
    return usuarioId;
  }

  public void setUsuarioId(int usuarioId) {
    this.usuarioId = usuarioId;
  }
}
