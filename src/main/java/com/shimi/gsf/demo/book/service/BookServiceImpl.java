package com.shimi.gsf.demo.book.service;

import com.shimi.gsf.core.exception.EntityDuplicatedException;
import com.shimi.gsf.core.repository.GeneralRepository;
import com.shimi.gsf.demo.book.event.BookCreatedEvent;
import com.shimi.gsf.demo.book.model.Book;
import com.shimi.gsf.demo.book.model.BookFilter;
import com.shimi.gsf.demo.book.repository.BookRepository;
import com.shimi.gsf.demo.book.repository.BookSpecs;
import com.shimi.gsf.demo.common.service.BaseDemoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;

@Service
public class BookServiceImpl extends BaseDemoServiceImpl<Book, BookFilter> implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private BookRepository repository;

    @Override
    protected GeneralRepository<Book> getRepository() {
        return repository;
    }

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void beforeCreate(Book book) {
        Book existingBook = this.repository.findByTitle(book.getTitle());

        if (existingBook != null) {
            throw new EntityDuplicatedException(MessageFormat.format("Book with same title already exists: {0}", book.getTitle()));
        }
    }

    @Override
    protected void afterCreate(Book book) {
        this.eventPublisher.publishEvent(new BookCreatedEvent(this, book));
    }

    /**
     * Sample event listener for BookCreatedEvent.
     * @param event the event that is published when a book is created.
     */
    @EventListener
    public void onBookCreated(BookCreatedEvent event) {
        Book book = event.getBook();
        log.info("BookCreatedEvent received: {}", event);
        // Additional logic can be added here if needed
    }

    @Override
    protected Specification<Book> toSpec(BookFilter filter) {
        Specification<Book> querySpec = null;

        if (StringUtils.hasText(filter.getKeyword())) {
            String keyword = filter.getKeyword();

            querySpec = BookSpecs.titleLike(keyword).or(BookSpecs.subtitleLike(keyword)).or(BookSpecs.isbnLike(keyword))
                    .or(BookSpecs.authorLike(keyword));
        }

        return querySpec;
    }
}
