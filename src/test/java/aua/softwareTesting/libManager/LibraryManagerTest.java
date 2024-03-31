package aua.softwareTesting.libManager;

import static org.junit.Assert.*;
import org.junit.Test;

public class LibraryManagerTest {

    @Test
    public void testAddBook() {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.addBook("1984");
        assertTrue(libraryManager.isBookAvailable("1984"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddBookWithEmptyTitle() {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.addBook("");
    }

    @Test
    public void testCheckOutBook() {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.addBook("The Great Gatsby");
        libraryManager.checkOutBook("The Great Gatsby");
        assertFalse(libraryManager.isBookAvailable("The Great Gatsby"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckOutNonExistingBook() {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.addBook("The Great Gatsby");
        libraryManager.checkOutBook("1984");
    }

    @Test
    public void testReturnBook() {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.addBook("The Power of Introverts in a World That Can't Stop Talking");
        libraryManager.checkOutBook("The Power of Introverts in a World That Can't Stop Talking");
        libraryManager.returnBook("The Power of Introverts in a World That Can't Stop Talking");
        assertTrue(libraryManager.isBookAvailable("The Power of Introverts in a World That Can't Stop Talking"));
    }

    @Test(expected = IllegalStateException.class)
    public void testNotCheckedOutBook() {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.addBook("Steppenwolf");
        libraryManager.addBook("Siddhartha");
        libraryManager.checkOutBook("Steppenwolf");
        libraryManager.returnBook("Steppenwolf");
        libraryManager.returnBook("Siddhartha");
    }

    @Test
    public void testIsBookAvailable() {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.addBook("The Things You Can See Only When You Slow Down");
        assertTrue(libraryManager.isBookAvailable("The Things You Can See Only When You Slow Down"));

        libraryManager.checkOutBook("The Things You Can See Only When You Slow Down");
        assertFalse(libraryManager.isBookAvailable("The Things You Can See Only When You Slow Down"));

        libraryManager.returnBook("The Things You Can See Only When You Slow Down");
        assertTrue(libraryManager.isBookAvailable("The Things You Can See Only When You Slow Down"));
    }
}
