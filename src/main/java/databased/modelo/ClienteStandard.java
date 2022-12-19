package databased.modelo;


public class ClienteStandard extends Cliente {

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
