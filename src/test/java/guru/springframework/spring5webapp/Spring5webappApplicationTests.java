package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Spring5webappApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testBookRepository() {
        long count = bookRepository.count();
    }

    @Test
    public void contextLoads() {
    }

}
