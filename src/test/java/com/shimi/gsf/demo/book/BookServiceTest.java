package com.shimi.gsf.demo.book;

import com.shimi.gsf.core.exception.EntityDuplicatedException;
import com.shimi.gsf.core.exception.ErrorCode;
import com.shimi.gsf.demo.book.model.Book;
import com.shimi.gsf.demo.book.repository.BookRepository;
import com.shimi.gsf.demo.book.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {
    private final BookRepository bookRepository = Mockito.mock(BookRepository.class);

    @Autowired
    private BookServiceImpl bookService;

//    @TestConfiguration
//    static class TestConfig {
//        @Bean(name = "mockBookRepository")
//        public BookRepository getBookRepository() {
//            return Mockito.mock(BookRepository.class);
//        }
//    }

    @BeforeEach
    public void setUp() {
        bookService.setRepository(this.bookRepository);

    }

//    private Book getBook() {
//        return getBook(null);
//    }

    private Book getNewBook() {
        Book book = new Book();
        Date now = new Date();
        book.setId(1L);
        book.setTitle("Effective Java Version 2");
        book.setSubtitle("Learn Java Language In Deep");
        book.setIsbn("T-202284736-JY-0874");
        book.setAuthor("Mark Anderson");
        book.setIntro("This is the best book to learn Java programming language, ever.");
        book.setPrice(55.0D);
        book.setCreatedTime(now);
        book.setUpdatedTime(now);
        return book;
    }

    @Test
    void testCreateBrandNew() {
        Mockito.when(bookRepository.save(Mockito.any(Book.class)))
                .thenReturn(getNewBook());

        Book savedBook = bookService.create(getNewBook());

        assertNotNull(savedBook);
        assertNotNull(savedBook.getId());
        assertTrue(savedBook.getId() > 0);
        assertNotNull(savedBook.getTitle());
        assertNotNull(savedBook.getSubtitle());
        assertNotNull(savedBook.getIsbn());
        assertNotNull(savedBook.getAuthor());
        assertNotNull(savedBook.getIntro());
        assertNotNull(savedBook.getPrice());
        assertNotNull(savedBook.getCreatedTime());
        assertNotNull(savedBook.getUpdatedTime());
    }

    @Test
    void testCreateDuplicated() {
        Mockito.when(bookRepository.findByTitle(Mockito.any(String.class)))
                .thenReturn(getNewBook());

        EntityDuplicatedException exception = assertThrows(EntityDuplicatedException.class, () -> {
            bookService.create(getNewBook());
        });

        assertEquals(ErrorCode.ENTITY_ALREADY_EXIST, exception.getCode());
        assertNotNull(exception.getMessage());
        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
    }
}
