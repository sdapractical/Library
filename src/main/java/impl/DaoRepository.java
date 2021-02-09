package impl;

public class DaoRepository {
    private static BookDao bookDao = new BookDaoImpl();
    private static ReaderDao readerDao = new ReaderDaoImpl();

    public static BookDao getBookDao() {
        return bookDao;
    }

    public static ReaderDao getReaderDao() {
        return readerDao;
    }
}
