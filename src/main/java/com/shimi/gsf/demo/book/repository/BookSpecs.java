package com.shimi.gsf.demo.book.repository;

import com.shimi.gsf.demo.book.model.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecs {
    private BookSpecs() {
    }

    public static Specification<Book> titleLike(String keyword) {
        return (book, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(book.get("title"),
                "%" + keyword + "%");
    }

    public static Specification<Book> subtitleLike(String keyword) {
        return (book, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(book.get("subtitle"),
                "%" + keyword + "%");
    }

    public static Specification<Book> isbnLike(String keyword) {
        return (book, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(book.get("isbn"),
                "%" + keyword + "%");
    }

    public static Specification<Book> authorLike(String keyword) {
        return (book, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(book.get("author"),
                "%" + keyword + "%");
    }
}
