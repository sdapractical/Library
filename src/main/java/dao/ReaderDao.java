package dao;


import domain.Reader;

import java.util.List;

public interface ReaderDao {

    void saveOrUpdate(Reader reader);
    List<Reader> getReaders();
    void deleteReaderByName(String readerName);
    void deleteReader(Reader reader);
}
