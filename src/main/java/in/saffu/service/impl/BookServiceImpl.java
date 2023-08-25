package in.saffu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.saffu.entity.BookEntity;
import in.saffu.repo.BookRepo;
import in.saffu.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo repo;

	@Override
	public Boolean insertBook(BookEntity book) {
		repo.save(book);
		return true;
	}

	@Override
	public List<BookEntity> getAllBooks() {
		return repo.findAll();	
	}

	@Override
	public BookEntity getBookById(Integer id) {
		 Optional<BookEntity> findById = repo.findById(id);
		 if (findById.isPresent()) {
		  return findById.get();
		}
		return null;
	
	}

	@Override
	public Boolean updateBook(BookEntity entity, Integer id) {
	    repo.save(entity);
		return true;
	}

	@Override
	public Boolean deleteById(Integer id) {
	   repo.deleteById(id);
		return true;
		 
	}

}
