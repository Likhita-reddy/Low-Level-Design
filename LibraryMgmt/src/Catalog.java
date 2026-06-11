import java.util.*;

public class Catalog {

    private Map<Book, List<BookCopy>> catalog;

    public Catalog(Map<Book, List<BookCopy>> catalog) {
        this.catalog = catalog;
    }

    public Optional<BookCopy> getAvailableCopy(Book book){
        if(catalog.containsKey(book)){
            List<BookCopy> copies = catalog.get(book);
            for(BookCopy copy: copies){
                if(copy.isAvailable()){
                    return Optional.of(copy);
                }
            }
        }
        return Optional.empty();
    }

    public List<BookCopy> searchBook(String title){
        for(Map.Entry<Book, List<BookCopy>> entry : catalog.entrySet()){
            if(entry.getKey().getTitle().equalsIgnoreCase(title)){
                return entry.getValue();
            }
        }
        return Collections.emptyList();
    }

    public void addBook(Book book, int copies){
        if(!catalog.containsKey(book)){
            List<BookCopy> bookCopies = new ArrayList<>();
            catalog.put(book, bookCopies);
        }
        for(int i=0;i<copies;i++){
            BookCopy copy = new BookCopy(catalog.get(book).size() + 1, book, true);
            catalog.get(book).add(copy);
        }

    }
}
