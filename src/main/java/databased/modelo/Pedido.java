package databased.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="num_pedido")
    private int numPedido;
    @ManyToOne()
    @JoinColumn(name = "email", nullable = false)
    private Cliente cliente;
    @ManyToOne()
    @JoinColumn(name = "codigo", nullable = false)
    private Articulo articulo;
    private int cantidad;
    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fechaPedido) {
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaEnvio(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public boolean pedidoEnviado(){

        long minutosTranscurridos = ChronoUnit.MINUTES.between(this.getFechaPedido(), LocalDateTime.now());

        return (articulo.getTiempoPreparacion() <= minutosTranscurridos);

    }

    public Double precioEnvio(){

        Double descuentoEnvio = articulo.getGastosEnvio() * cliente.descuentoEnvio() / 100;
        Double gastosEnvio = articulo.getGastosEnvio() - descuentoEnvio;
        Double precioTotal = articulo.getPrecioVenta() * this.cantidad + gastosEnvio;

        return precioTotal;
    }

    @Override
    public String toString() {
        return "\nPedido{" +
                "Núm. pedido: " + numPedido +
                ",Fecha y hora del pedido: " + fechaPedido +
                ", NIF: " + cliente.getNif() +
                ", Nombre: " + cliente.getNombre() +
                ", Código artículo: " + articulo.getCodigo() +
                ", Descripción artículo: " + articulo.getDescripcion() +
                ", Cantidad: " + cantidad +
                ", Precio artículo: " + articulo.getPrecioVenta() +
                ", Coste envío: " + articulo.getGastosEnvio() +
                ", Precio total: " + this.precioEnvio() + //TODO Duda de si esto es el precio total o el precio de envio por el numero de articulos
                ", Enviado: " + this.pedidoEnviado() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido empObject = (Pedido) o;
        if (numPedido != empObject.numPedido) return false;
        return true;
    }
}
