package com.shimi.gsf.demo.book.model;

import com.shimi.gsf.core.model.BaseFilter;

import java.io.Serial;

public class BookFilter extends BaseFilter {
    @Serial
    private static final long serialVersionUID = 3169970865817419310L;
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
