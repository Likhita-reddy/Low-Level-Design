public class BookCopy {
    private int copyId;
    private Book book;
    private boolean isAvailable;

    public BookCopy(int copyId, Book book, boolean isAvailable) {
        this.copyId = copyId;
        this.book = book;
        this.isAvailable = isAvailable;
    }

    public int getCopyId() {
        return copyId;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowCopy(){
        isAvailable = false;
    }

    public void returnCopy(){
        isAvailable = true;
    }
}
