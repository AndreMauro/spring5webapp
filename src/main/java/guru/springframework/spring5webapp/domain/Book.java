package guru.springframework.spring5webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String isbn;
    private String publisher;

    public Book() {
    }

    public Book(String title, String isbn, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }
}
