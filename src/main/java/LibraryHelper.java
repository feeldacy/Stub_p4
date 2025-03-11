import java.util.List;

public class LibraryHelper {

    public LibraryService service;

    public LibraryHelper(LibraryService service){
        this.service = service;
    }

    public int countBook(){
        List<Book> books = this.service.getAllBooks();

        return  books.size();
    }

    public void saveBooks(List<Book> books){
        if (books.size() > 0){
            this.service.saveBooks(books);
        }
    }
}
