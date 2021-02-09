package impl;

import java.util.List;

public interface BookDao {

   void addBook(Book book);
   void issueBookToReader (Book book);
   void returnBookToThePool (List<Book> books);
}
