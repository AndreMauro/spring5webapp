package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class SpringJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Commit
    //@Rollback(false)
    @Order(1)
    @Test
    public void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(0);

        bookRepository.save(new Book("My Book", "1235555", "Self"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    public void testJpaTestSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);

    }
}
