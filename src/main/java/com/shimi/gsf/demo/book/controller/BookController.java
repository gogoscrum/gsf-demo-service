package com.shimi.gsf.demo.book.controller;

import com.shimi.gsf.core.dto.Dto;
import com.shimi.gsf.core.dto.DtoQueryResult;
import com.shimi.gsf.core.model.EntityQueryResult;
import com.shimi.gsf.demo.book.dto.BookDto;
import com.shimi.gsf.demo.book.model.BookFilter;
import com.shimi.gsf.demo.book.model.Book;
import com.shimi.gsf.demo.book.service.BookService;
import com.shimi.gsf.demo.common.controller.BaseDemoController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/books")
@CrossOrigin
@Tag(name = "Books", description = "Book management APIs")
public class BookController extends BaseDemoController {
    @Autowired
    private BookService bookService;

    @Operation(summary = "Create a new book")
    @PostMapping
    public BookDto create(@RequestBody BookDto bookDto) {
        Book savedBook = bookService.create(bookDto.toEntity());
        return savedBook.toDto(true);
    }

    @Operation(summary = "Get a book by ID")
    @Parameters({@Parameter(name = "id", description = "The book ID")})
    @GetMapping("/{id}")
    public BookDto get(@PathVariable Long id) {
        Book book = bookService.get(id);
        return book.toDto(true);
    }

    @Operation(summary = "Update a book by ID")
    @Parameters({
            @Parameter(name = "id", description = "The book ID")})
    @PutMapping("/{id}")
    public BookDto update(@PathVariable Long id, @RequestBody BookDto bookDto) {
        Book updatedBook = bookService.update(id, bookDto.toEntity());
        return updatedBook.toDto(true);
    }

    @Operation(summary = "Delete a book by ID")
    @Parameters({@Parameter(name = "id", description = "The book ID")})
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @Operation(summary = "Search for books")
    @Parameters({
            @Parameter(name = "filter", description = "The book filter")})
    @GetMapping
    public DtoQueryResult<Dto> search(@RequestParam(required = false) BookFilter filter) {
        EntityQueryResult<Book> queryResult = bookService.search(Objects.requireNonNullElse(filter, new BookFilter()));
        return queryResult.toDto();
    }
}
