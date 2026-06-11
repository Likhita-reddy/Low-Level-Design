import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LibrarySystem {
    private Catalog catalog;
    private Map<Integer, User> registeredUsers;

    public LibrarySystem() {
        this.catalog = new Catalog(new HashMap<>());
        this.registeredUsers = new HashMap<>();
    }

    public void registerUser(User user){
        if(registeredUsers.containsKey(user.getId())){
            System.out.println("User is already registered!");
            return;
        }
        registeredUsers.put(user.getId(), user);
    }

    public void addBook(Book book, int copies){
        catalog.addBook(book, copies);
    }

    public Optional<BorrowedRecord> borrowBook(Book book, User user){
        if(!user.isApplicable()){
            return Optional.empty();
        }
        Optional<BookCopy> availableCopy = catalog.getAvailableCopy(book);
        if(availableCopy.isEmpty()){
            System.out.println("Book is not available!");
            return Optional.empty();
        }

        BorrowedRecord borrowedRecord = new BorrowedRecord(0, availableCopy.get(), user);
        user.borrowBook(borrowedRecord);
        availableCopy.get().borrowCopy();
        return Optional.of(borrowedRecord);

    }

    public void returnBook(BorrowedRecord borrowedRecord){
        User user = borrowedRecord.getUser();
        if(!user.hasBorrowedBook(borrowedRecord)){
            System.out.println("This record doesn't belon to user");
            return;
        }
        BookCopy copy = borrowedRecord.getBookCopy();
        if(copy.isAvailable()){
            System.out.println("This book is already returned");
            return;
        }
        user.returnBook(borrowedRecord);
        copy.returnCopy();

    }

    public List<BookCopy> searchBook(String title){
        return catalog.searchBook(title);
    }
}
