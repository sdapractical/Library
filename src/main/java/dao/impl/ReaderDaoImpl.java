package dao.impl;

import config.HibernateUtils;
import dao.ReaderDao;
import domain.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ReaderDaoImpl implements ReaderDao {


    @Override
    public void saveOrUpdate(Reader reader) {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.saveOrUpdate(reader);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Reader> getReaders() {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            String queryString = "SELECT c FROM Reader c";
            Query query = session.createQuery(queryString, Reader.class);
            return query.getResultList();
        }
    }

    @Override
    public void deleteReaderByName(String readerName) {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            String queryString = "DELETE FROM Reader WHERE firstName = :readerNameParam";
            Query query = session.createQuery(queryString);
            query.setParameter("readerNameParam", readerName);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteReader(Reader reader) {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();
            session.delete(reader);
            session.getTransaction().commit();
        }
    }

    }

