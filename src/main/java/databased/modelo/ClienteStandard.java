package databased.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="ClienteStandard")
public class ClienteStandard extends Cliente {
    private int cuota = 0;
    private int descuento = 0;
    public ClienteStandard() {
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public ClienteStandard(String email, String nif, String nombre, String domicilio) {
        super(email, nif, nombre, domicilio);
    }

    @Override
    public String tipoCliente() {
        return "ClienteStandard";
    }

    @Override
    public double calcAnual() {
        return 0;
    }

    @Override
    public double descuentoEnvio() {
        return 0;
    }

    @Override
    public String toString() {
        return "\nClienteStandard{" +
                "email='" + email + '\'' +
                ", nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }

    /**
     * Método sobrecargado de Cliente usado para clonar objetos de tipo Cliente (casteado a ClienteStandard)
     * @param clienteOld Objeto de tipo Cliente del que se va a hacer la copia
     * @return Objeto ClienteStandard que es una copia del objeto Cliente pasado por parámetro
     * @see Cliente
     */
    @Override
    public Cliente clona(Cliente clienteOld) {
        ClienteStandard clienteNew = (ClienteStandard) clienteOld;
        return new ClienteStandard(clienteNew.getEmail(), clienteNew.getNif(), clienteNew.getNombre(), clienteNew.getDomicilio());
    }
}
