public class BorrowedRecord {
    private int borrowId;
    private BookCopy bookCopy;
    private User user;

    public BorrowedRecord(int borrowId, BookCopy bookCopy, User user) {
        this.borrowId = borrowId;
        this.bookCopy = bookCopy;
        this.user = user;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public User getUser() {
        return user;
    }
}
