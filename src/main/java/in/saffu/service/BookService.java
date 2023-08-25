package in.saffu.service;

import java.util.List;

import in.saffu.entity.BookEntity;

public interface BookService {
	
	public Boolean insertBook(BookEntity book);
	
	public List<BookEntity> getAllBooks();
	
	public BookEntity getBookById(Integer id);
	
	public Boolean updateBook(BookEntity entity,Integer id);
	
	public Boolean deleteById(Integer id);
	
	

}
