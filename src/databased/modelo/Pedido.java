package databased.modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Pedido {
    private int numPedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private LocalDateTime fechaPedido;

    public Pedido(int numPedido, Cliente cliente, Articulo articulo, int cantidad, LocalDateTime fechaPedido) {
        this.numPedido = numPedido;
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
        //Se debe indicar si ha transcurrido el tiempo de preparación
        long minutosTranscurridos = ChronoUnit.MINUTES.between(this.getFechaPedido(), LocalDateTime.now());
        if(articulo.getTiempoPreparacion() < minutosTranscurridos)
            return false;
        else
            return true;
    }
    public Double precioEnvio(){
        //Para calcular el precio del pedido hay que tener en cuenta el precio de venta,
        // las unidades pedidas,
        // el coste del envío y si el cliente que lo ha realizado es premium.
        // Si es premium paga una cuota anual de 30 euros y se le aplica un 20% de descuento en los gastos de envío de cada pedido

        Double descuentoEnvio = articulo.getGastosEnvio() * cliente.descuentoEnvio() / 100;
        Double gastosEnvio = articulo.getGastosEnvio() - descuentoEnvio;
        Double precioTotal = articulo.getPrecioVenta() * this.cantidad - gastosEnvio;

        return precioTotal;
    };

    // El método toString debe construir una cadena con los datos siguientes:
    // número de pedido, fecha y hora del pedido, Nif y nombre del cliente, código y descripción del artículo,
    // cantidad, precio artículo, coste envío, precio total y si ya se ha enviado.

    @Override
    public String toString() {
        return "Pedido{" +
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
