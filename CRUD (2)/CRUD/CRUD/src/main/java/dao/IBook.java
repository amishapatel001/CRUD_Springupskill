package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Book;

public interface IBook extends JpaRepository<Book, Integer> {

}
