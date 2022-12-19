package databased.vista;

public class NoDecimalInsertException extends Exception{
    ColoresConsola colores = new ColoresConsola();
    @Override
    public String getMessage(){

        return colores.consola("El dato introducido debe ser un numero entero o un decimal válido", 42);
    }
}