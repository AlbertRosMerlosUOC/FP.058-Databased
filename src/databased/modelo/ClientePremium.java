package src.databased.modelo;

public class ClientePremium extends Cliente {
    private int cuota = 30;
    private int descuento = 20;

    public ClientePremium(String email, String nif, String nombre, String domicilio) {
        super(email, nif, nombre, domicilio);
    }

    public ClientePremium(String email, String nif, String nombre, String domicilio, int cuota, int descuento) {
        super(email, nif, nombre, domicilio);
        this.cuota = cuota;
        this.descuento = descuento;
    }

    @Override
    public String tipoCliente() {
        return "Premium";
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public double calcAnual() {
        //TODO
        return 0;
    }

    @Override
    public double descuentoEnvio() {
        //TODO
        return 0;
    }

    @Override
    public String toString() {
        return "ClientePremium{" +
                "cuota=" + cuota +
                ", descuento=" + descuento +
                ", email='" + email + '\'' +
                ", nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }

    /**
     * Método sobrecargado de Cliente usado para clonar objetos de tipo Cliente (casteado a ClientePremium)
     * @param clienteOld Objeto de tipo Cliente del que se va a hacer la copia
     * @return Objeto ClientePremium que es una copia del objeto Cliente pasado por parámetro
     * @see Cliente
     */
    @Override
    public Cliente clona(Cliente clienteOld) {
        ClientePremium clienteNew = (ClientePremium) clienteOld;
        return new ClientePremium(clienteNew.getEmail(), clienteNew.getNif(), clienteNew.getNombre(),
                                  clienteNew.getDomicilio(), clienteNew.getCuota(), clienteNew.getDescuento());
    }
}
