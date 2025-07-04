package com.shimi.gsf.demo.book.model;

import com.shimi.gsf.demo.book.dto.BookDto;
import com.shimi.gsf.demo.common.entity.BaseDemoEntity;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Entity;

import java.io.Serial;

@Entity
public class Book extends BaseDemoEntity {
    @Serial
    private static final long serialVersionUID = -1160435223851775784L;
    private String title;
    private String subtitle;
    private String isbn;
    private String author;
    private String intro;
    private Double price;

    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }

    @Override
    public BookDto toDto() {
        return this.toDto(false);
    }

    @Override
    public BookDto toDto(boolean detailed) {
        BookDto dto = new BookDto();
        BeanUtils.copyProperties(this, dto);

        if (detailed) {
            if (this.createdBy != null) {
                dto.setCreatedBy(this.createdBy.toDto());
            }
            if (this.updatedBy != null) {
                dto.setUpdatedBy(this.updatedBy.toDto());
            }
        }

        return dto;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}