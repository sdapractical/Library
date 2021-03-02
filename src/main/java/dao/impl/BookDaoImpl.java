package dao.impl;


import config.HibernateUtils;
import dao.BookDao;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void getBookById(Book book) {

    }

    @Override
    public void saveOrUpdate(Book book) {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
        }

    }


    @Override
    public List<Book> getBooks() {
        try(SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            String queryString = "SELECT f FROM Book f";
            Query query = session.createQuery(queryString, Book.class);
            return query.getResultList();
        }
    }



    @Override
    public void delete(Book book) {
        try(SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
            Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
        }
    }

}
