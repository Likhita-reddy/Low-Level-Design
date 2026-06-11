import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<BorrowedRecord> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean isApplicable(){
        return borrowedBooks.size() < 3;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<BorrowedRecord> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(BorrowedRecord borrowedRecord){
        borrowedBooks.add(borrowedRecord);
    }

    public void returnBook(BorrowedRecord borrowedRecord){
        borrowedBooks.remove(borrowedRecord);
    }

    public boolean hasBorrowedBook(BorrowedRecord borrowedRecord){
        return borrowedBooks.contains(borrowedRecord);
    }
}
