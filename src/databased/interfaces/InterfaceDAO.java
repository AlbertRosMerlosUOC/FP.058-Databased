package databased.interfaces;

import java.util.List;

public interface InterfaceDAO<T, K> {
    public boolean create(T t);
    public boolean update (T t);
    public boolean delete(T t);
    public T read(K id);
    public List<T> readAll();
}
