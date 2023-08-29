package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IBook;
import model.Book;

@RestController
public class BookController {

	@Autowired
	IBook book;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to spring Boot  project.";
	}
	
	// add

		@PostMapping("/addBooks")
		public String addBook(@RequestBody Book b) {
			book.save(b);
			return "Book Added successfully!!!!";
		}


	@GetMapping("viewBooks")
	public List<Book> viewBooks() {
		return book.findAll();
	}

	@DeleteMapping("deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		book.deleteById(id);
		return "Book Deleted successfully!!";
	}

	@PutMapping("updateBook")
	public String updateBook(@RequestBody Book b) {
		book.findById(b.getId()).map(update -> {
			update.setId(b.getId());
			update.setName(b.getName());
			update.setPrice(b.getPrice());
			return book.save(update);
		});
		return "Book Updated successfully";
	}

	@PutMapping("updateBook1/{id}")
	public String updateBook(@RequestBody Book b, @PathVariable("id") int id) {
		book.findById(b.getId()).map(update -> {
			update.setName(b.getName());
			update.setPrice(b.getPrice());
			return book.save(update);
		});
		return "Book Updated succuessfully";
	}

	@GetMapping("searchBook/{id}")
	public String searchBook(@PathVariable("id") int id) {
		return book.findById(id).get().getName();
	}


}
