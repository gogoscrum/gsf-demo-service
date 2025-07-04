package com.shimi.gsf.demo.book.event;

import com.shimi.gsf.demo.book.model.Book;

import java.io.Serial;

/**
 * BookCreatedEvent is an event that represents the creation of a book. It extends the BaseDemoEvent class.
 * This event is used to notify listeners about the creation of a new book.
 */
public class BookCreatedEvent extends BaseDemoEvent {
    @Serial
    private static final long serialVersionUID = 3035519580706191802L;
    private Book book;

    public BookCreatedEvent(Object source) {
        super(source);
    }

    public BookCreatedEvent(Object source, Book book) {
        super(source);
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookCreatedEvent{");
        sb.append("book=").append(book);
        sb.append('}');
        return sb.toString();
    }
}
