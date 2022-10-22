package databased.modelo;

import java.util.ArrayList;

public class Lista<T> {
    protected ArrayList<T> lista;
    public Lista() {
        lista = new ArrayList<>();
    }
    public int getSize() {
// TO-BE-DONE
        return 0;
    }
    public boolean add(T t) throws EscrituraAccesoDatoException {
        if(t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        if(lista.contains(t)){
            throw new EscrituraAccesoDatoException("Error el objeto con id " + t + " existe en repositorio");
        }
        boolean addOk =   lista.add(t);
        return addOk;
    }
    public void borrar(T t) {
// TO-BE-DONE
    }
    public T getAt(int position) {
// TO-BE-DONE
        return null;
    }
    public void clear() {
// TO-BE-DONE
    }
    public boolean isEmpty() {
// TO-BE-DONE
        return false;
    }
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(lista);
        return arrlist;
    }
    public void list(){
        System.out.println("---Artículos en el sistema----");
        lista.forEach(System.out::println);
    }
}