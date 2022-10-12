package src.databased.modelo;

public abstract class Cliente {
    protected String email;
    protected String nif;
    protected String nombre;
    protected String domicilio;

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

}
