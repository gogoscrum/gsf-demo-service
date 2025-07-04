package com.shimi.gsf.demo.book.repository;

import com.shimi.gsf.core.repository.GeneralRepository;
import com.shimi.gsf.demo.book.model.Book;

public interface BookRepository extends GeneralRepository<Book> {
    Book findByTitle(String title);
}
