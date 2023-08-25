package in.saffu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saffu.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity,Integer >{

}
