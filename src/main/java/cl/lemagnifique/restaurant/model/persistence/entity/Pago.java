package cl.lemagnifique.restaurant.model.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="fecha_pago")
    private Date fechaPago;
    @Column(name="monto")
    private float monto;
    @ManyToOne
    @JoinColumn(name = "cliente_id", insertable = true, updatable = false)
    private Cliente cliente;

    public Pago() {
    }

    public Pago(int id, Date fechaPago, float monto, Cliente cliente) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
