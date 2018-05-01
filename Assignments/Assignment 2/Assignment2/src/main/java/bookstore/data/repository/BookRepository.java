package bookstore.data.repository;
import bookstore.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer>
{
        Book findByIsbn(String isbn);
        List<Book> findAllByGenreContaining(String genre);
        Book getByTitle(String title);
        List<Book> findAllByAuthor(String author);

        @Modifying
        @Transactional
        @Query("update Book b set b.quantity = ?1, b.title= ?2, b.price= ?3 where b.isbn = ?4")
        void updateBook(int quantity,String name,int price,String isbn);
}

