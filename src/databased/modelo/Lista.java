package databased.modelo;

import java.util.ArrayList;

public class Lista<T> {
    protected ArrayList<T> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public int getSize() {
        // TODO
        return 0;
    }

    public void add(T t) {
        // TODO
    }

    public void borrar(T t) {
        // TODO
    }

    public T getAt(int position) {
        // TODO
        return null;
    }

    public void clear() {
        // TODO
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(lista);
        return arrlist;
    }
}
