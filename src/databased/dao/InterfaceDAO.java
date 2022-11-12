package databased.dao;
import org.xml.sax.SAXException;
import java.util.List;

public interface InterfaceDAO<T, K> {
        public void createItem(T t) throws DAOException;
        public T getItem(K id) throws DAOException;
        public void putItem (T t) throws DAOException;
        public void deleteItem(T t) throws DAOException;
        public List<T> getAll() throws DAOException;
}
