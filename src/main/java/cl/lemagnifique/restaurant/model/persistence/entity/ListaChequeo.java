package cl.lemagnifique.restaurant.model.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="chequeo")
public class ListaChequeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "estado")
    private String estado;
    @ManyToOne
    @JoinColumn(name = "visita_id", insertable = true, updatable = false)
    private Visita visita;

    public ListaChequeo() {
    }

    public ListaChequeo(int id, String detalle, String estado, Visita visita) {
        this.id = id;
        this.detalle = detalle;
        this.estado = estado;
        this.visita = visita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
    }
}