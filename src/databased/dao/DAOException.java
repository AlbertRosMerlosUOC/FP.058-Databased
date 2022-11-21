package databased.dao;

public class DAOException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DAOException(String msg, Throwable reason) {
        super(msg, reason);
    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(Throwable reason) {
        super(reason);
    }
}
