import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    public List<Book> getAllBooks(){
        // ini seharusnya baca dari db
        List<Book> books = new ArrayList<>();
        return books;
    }

    public void saveBooks(List<Book> books){
        // seharusnya insert books ke db
    }
}
