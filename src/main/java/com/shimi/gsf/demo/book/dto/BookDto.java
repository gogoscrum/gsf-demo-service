package com.shimi.gsf.demo.book.dto;

import com.shimi.gsf.demo.book.model.Book;
import com.shimi.gsf.demo.common.dto.BaseDemoDto;
import org.springframework.beans.BeanUtils;

import java.io.Serial;

public class BookDto extends BaseDemoDto {
    @Serial
    private static final long serialVersionUID = 8062839279046369071L;

    private String title;
    private String subtitle;
    private String isbn;
    private String author;
    private String intro;
    private Double price;

    @Override
    public Book toEntity() {
        Book entity = new Book();

        BeanUtils.copyProperties(this, entity);

        return entity;
    }

    public BookDto() {
    }

    public BookDto(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
