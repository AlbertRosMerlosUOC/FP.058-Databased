package databased.modelo;

import java.time.LocalDateTime;

public class Pedido {
    private int numPedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private LocalDateTime fechaEnvio;

    public Pedido(int numPedido, Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fechaEnvio) {
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fechaEnvio = fechaEnvio;
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

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean pedidoEnviado(){
        //TODO
        return true;
    }
    public float precioEnvio(){
        //TODO
        return 0;
    };
    //TODO
    // El método toString debe construir una cadena con los datos siguientes:
    // número de pedido, fecha y hora del pedido, Nif y nombre del cliente, código y descripción del artículo,
    // cantidad, precio artículo, coste envío, precio total y si ya se ha enviado.
}
