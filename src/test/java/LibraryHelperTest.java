import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class LibraryHelperTest {

    @Mock
    private LibraryService service;

    @InjectMocks
    private LibraryHelper helper;

    @Test
    public void testCountBook(){
        List<Book> books = new ArrayList<>();

        books.add(new Book(1, "OOP Itu Mudah", "Joko"));
        books.add(new Book(2, "Detective Conan", "Siti"));

        Mockito.when(service.getAllBooks()).thenReturn(books);

        Assertions.assertEquals(2, helper.countBook());
    }

    @Test
    public void testSaveEmptyBook(){
        List<Book> books = new ArrayList<>();

        //        LibraryService service = Mockito.mock(LibraryService.class); //dummy class
        //        LibraryHelper helper = new LibraryHelper(service);


        helper.saveBooks(books); //helper

        Mockito.verify(service, Mockito.never()).saveBooks(any()); //service
    }


    @Test
    public void testSaveNotEmptyBook(){
        List<Book> books = new ArrayList<>();

        //        LibraryService service = Mockito.mock(LibraryService.class); //dummy class
        //        LibraryHelper helper = new LibraryHelper(service);

        books.add(new Book(1, "OOP Itu Mudah", "Joko"));
        books.add(new Book(2, "Detective Conan", "Siti"));

        helper.saveBooks(books); //helper
        Mockito.verify(service).saveBooks(books); //mastiin fungsinya kepanggil at ga
    }


    @Test
    public void testCountBookDoReturn() {
        List<Book> books = new ArrayList<>();

        books.add(new Book(1, "OOP Itu Mudah", "Joko"));
        books.add(new Book(2, "Detective Conan", "Siti"));

        Mockito.doReturn(books).when(service).getAllBooks();

        Assertions.assertEquals(2, helper.countBook());
    }

    @Test
    public void testResetMock() {
        List<Book> books = new ArrayList<>();

        books.add(new Book(1, "OOP Itu Mudah", "Joko"));
        books.add(new Book(2, "Detective Conan", "Siti"));

        Mockito.when(service.getAllBooks()).thenReturn(books);
        Assertions.assertEquals(2, helper.countBook());

        Mockito.reset(service);

        Assertions.assertEquals(0, helper.countBook());
    }

}
