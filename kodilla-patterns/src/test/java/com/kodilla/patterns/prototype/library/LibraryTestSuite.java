package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Title" + n, "Author" + n, LocalDate.now().minusYears(n))));

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Library 2");

        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");

        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().add(new Book("Title 11", "Author 11", LocalDate.now().minusYears(11)));

        //When
        Set<Book> books1 = library.getBooks();
        Set<Book> books2 = shallowClonedLibrary.getBooks();
        Set<Book> books3 = deepClonedLibrary.getBooks();

        //Then
        System.out.println(books1);
        System.out.println(books2);
        System.out.println(books3);
        Assert.assertEquals(11, books1.size());
        Assert.assertEquals(11, books2.size());
        Assert.assertEquals(10, books3.size());
        Assert.assertEquals(books1, books2);
        Assert.assertNotEquals(books1, books3);
    }

}
