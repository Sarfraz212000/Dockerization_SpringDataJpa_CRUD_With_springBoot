package in.saffu.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.saffu.constant.AppConstants;
import in.saffu.entity.BookEntity;
import in.saffu.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService service;

	@PostMapping("/insert")
	public ResponseEntity<String> insertRecord(@Valid @RequestBody BookEntity book) {
		Boolean status = service.insertBook(book);
		if (status) {
			return new ResponseEntity<>(AppConstants.SAVED_DATA, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(AppConstants.NOT_SAVED_DATA, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> books = service.getAllBooks();
		return new ResponseEntity<List<BookEntity>>(books, HttpStatus.OK);
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<BookEntity> getBookById(@PathVariable Integer id) {
		BookEntity book = service.getBookById(id);
		return new ResponseEntity<BookEntity>(book, HttpStatus.OK);
	}
	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		Boolean status = service.deleteById(id);
		if (status) {
			return new ResponseEntity<String>(AppConstants.DELETD_DATA,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(AppConstants.NOT_DELETD_DATA,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/books/{id}")
	public ResponseEntity<String> updateRecord(@Valid @RequestBody BookEntity entiy,@PathVariable Integer id){
		Boolean status = service.updateBook(entiy, id);
		if (status) {
			return new ResponseEntity<String>(AppConstants.UPDATED_DATA,HttpStatus.OK);
		}
		return new ResponseEntity<String>(AppConstants.NOT_UPADTED_DATA,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
