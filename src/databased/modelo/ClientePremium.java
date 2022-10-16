package databased.modelo;

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
        //TODO
        return null;
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
}
