package databased.vista;

public class NoEnteroInsertException extends Exception{
    ColoresConsola colores = new ColoresConsola();
    @Override
    public String getMessage(){

        return colores.consola("El dato introducido debe ser un numero " +
                "entero válido", 42);
    }
}