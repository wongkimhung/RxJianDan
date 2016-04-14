package com.rtfsc.rxjiandan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rtfsc on 2016/4/13.
 */
public class Comment4Pic implements Serializable {
    private String status;
    private int current_page;
    private int total_comments;
    private int page_count;
    private List<Picture> comments;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_comments() {
        return total_comments;
    }

    public void setTotal_comments(int total_comments) {
        this.total_comments = total_comments;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public List<Picture> getComments() {
        return comments;
    }

    public void setComments(List<Picture> comments) {
        this.comments = comments;
    }
}
