package aua.softwareTesting.libManager;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<String> library;
    private List<String> checkedOutBooks;

    public LibraryManager() {
        this.library = new ArrayList<>();
        this.checkedOutBooks = new ArrayList<>();
    }

    public void addBook(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Invalid book title");
        }
        library.add(title);
    }

    public void checkOutBook(String title) {
        if (title.isEmpty() || !library.contains(title)) {
            throw new IllegalArgumentException("Book not found");
        }
        library.remove(title);
        checkedOutBooks.add(title);
    }

    public void returnBook(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Invalid book title");
        }

        if (!checkedOutBooks.contains(title)) {
            throw new IllegalStateException("Book not previously checked out");
        }

        library.add(title);
        checkedOutBooks.remove(title);
    }

    public boolean isBookAvailable(String title) {
        return library.contains(title);
    }
}

