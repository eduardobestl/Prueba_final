package cl.lemagnifique.restaurant.model.persistence.entity;

import jakarta.persistence.*;
@Entity
@Table(name="usuario")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;

  @Column(name="nombre")
  private String nombre;

  @Column(name="username")
  private String username;

  @Column(name="password")
  private String password;


  public Usuario() {
  }

  public Usuario(int id, String nombre, String username, String password) {
    this.id = id;
    this.nombre = nombre;
    this.username = username;
    this.password = password;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
