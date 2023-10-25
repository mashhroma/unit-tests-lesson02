package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Задание 2.
 * У вас есть класс BookService, который использует интерфейс BookRepository
 * для получения информации о книгах из базы данных.
 * Ваша задача написать unit-тесты для BookService,
 * используя Mockito для создания мок-объекта BookRepository.
 * */
class BookServiceTest {

    @Test
    void findBookByIdTest(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookRepository.findById("1")).thenReturn(new Book("1", "Dubrovskiy", "Puskin"));

        Book book = bookService.findBookById("1");

        verify(bookRepository, times(1)).findById("1");
        assertEquals(bookRepository.findById("1"), book);
    }

    @Test
    void findAllBooks(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        when(bookRepository.findAll()).thenReturn(Arrays.asList(new Book("1", "Dubrovskiy", "Puskin"), new Book("2", "Revizor", "Gogol")));

        List<Book> allBooks = bookService.findAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertEquals(bookRepository.findAll(), allBooks);
    }

    @Test
    void findByIdTest(){
        InMemoryBookRepository inMemoryBookRepository = mock(InMemoryBookRepository.class);
        BookRepository bookRepository = inMemoryBookRepository;
        when(inMemoryBookRepository.findById("1")).thenReturn(new Book("1", "Dubrovskiy", "Puskin"));

        Book book = bookRepository.findById("1");

        verify(inMemoryBookRepository, times(1)).findById("1");
        assertEquals(inMemoryBookRepository.findById("1"), book);
    }

    @Test
    void findAll(){
        InMemoryBookRepository inMemoryBookRepository = mock(InMemoryBookRepository.class);
        BookRepository bookRepository = inMemoryBookRepository;
        when(inMemoryBookRepository.findAll()).thenReturn(Arrays.asList(new Book("1", "Dubrovskiy", "Puskin"), new Book("2", "Revizor", "Gogol")));

        List<Book> allBooks = bookRepository.findAll();

        verify(inMemoryBookRepository, times(1)).findAll();
        assertEquals(inMemoryBookRepository.findAll(), allBooks);
    }

    @Test
    void getIdTest(){
        Book book = new Book("1", "Dubrovskiy", "Puskin");

        String bookId = book.getId();

        assertEquals(bookId, "1");
    }
    @Test
    void setIdTest(){
        Book book = new Book("1", "Dubrovskiy", "Puskin");

        book.setId("001");

        assertEquals(book.getId(), "001");
    }
    @Test
    void getTitleTest(){
        Book book = new Book("1", "Dubrovskiy", "Puskin");

        String bookTitle = book.getTitle();

        assertEquals(bookTitle, "Dubrovskiy");
    }
    @Test
    void setTitleTest(){
        Book book = new Book("1", "Dubrovskiy", "Puskin");

        book.setTitle("Dubrovskiy");

        assertEquals(book.getTitle(), "Dubrovskiy");
    }
    @Test
    void getAuthorTest(){
        Book book = new Book("1", "Dubrovskiy", "Puskin");

        String bookAuthor = book.getAuthor();

        assertEquals(bookAuthor, "Puskin");
    }
    @Test
    void setAuthorTest(){
        Book book = new Book("1", "Dubrovskiy", "Puskin");

        book.setAuthor("Puskin");

        assertEquals(book.getAuthor(), "Puskin");
    }
}