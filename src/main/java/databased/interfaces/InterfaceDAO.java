package databased.interfaces;

import java.util.List;

import databased.dao.DAOException;


public interface InterfaceDAO<T, K> {

    public T create(T t) throws DAOException;

    public boolean update (T t) throws DAOException;

    public boolean delete(K id) throws DAOException;

    public T read(K id) throws DAOException;
    public List<T> readAll() throws DAOException;
}
