package databased.modelo;

import java.util.ArrayList;


public class Lista<T> {
    protected ArrayList<T> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public int getSize() {
        return lista.size();
    }

    public boolean add(T t) {
        if(lista.contains(t))
            return false;
        lista.add(t);
        return true;
    }

    public boolean delete(T t) {
        if(lista.contains(t))
            return false;
        lista.remove(t);
        return true;
    }

    public T getAt(int position) {
        return lista.get(position);
    }

    public void clear() {
        lista.clear();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(lista);
        return arrlist;
    }
}