package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void testPublicationYearMedian() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("author1", "title1", 2000, "1"));
        bookSet.add(new Book("author2", "title2", 2001, "2"));
        bookSet.add(new Book("author3", "title3", 2002, "3"));

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        System.out.println(median);

        //Then
        assertEquals(median, 2001);
    }
}