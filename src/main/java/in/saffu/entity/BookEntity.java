package in.saffu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "BOOK_TAB")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;

	@Column(name = "NAME")
	@NotBlank(message = "Please enter proper BookName name")
	@Size(min=2, message = "BookName should be atleast 2 characters")
	@Size(max = 20, message = "BookName should not be greater than 20 characters")
	private String bookName;

	@Column(name = "AUTHOR")
	@NotBlank(message = "Please enter proper Author name")
	@Size(min=2, message = "Author Name should be atleast 2 characters")
	@Size(max = 20, message = "Author Name should not be greater than 15 characters")
	private String bookAuthor;

	@Column(name = "PRICE")
	@NotNull(message = "Please enter a valid amount")
	@Min(value=200, message = "Book price must be greater or equal to 200")
	private Long bookPrice;

}
