package databased.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cliente", discriminatorType = DiscriminatorType.STRING)
public abstract class Cliente {
    @Id
    protected String email;
    protected String nif;
    protected String nombre;
    protected String domicilio;

    public Cliente() {
    }

    public Cliente(String email, String nif, String nombre, String domicilio) {
        this.email = email;
        this.nif = nif;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    abstract public String tipoCliente();
    abstract public double calcAnual();
    abstract public double descuentoEnvio();

    /**
     * Método que simula una clonación de subtipos Cliente (ClientePremium, ClienteStandard)
     * @param clienteOld Objeto tipo Cliente que será clonado
     * @return Objeto tipo Producto clonado
     * @see ClientePremium
     * @see ClienteStandard
     */
    public abstract Cliente clona(Cliente clienteOld);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente empObject = (Cliente) o;
        if (!email.equals(empObject.email)) return false;

        return true;
    }
}
