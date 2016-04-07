package com.rtfsc.rxjiandan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kdroid on 16-3-29.
 */
public class FreshNews implements Serializable {
    public static final int PAGE_FIRST = 1;
    private String status;
    private int count;
    private int count_total;
    private int pages;
    private List<Post> posts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_total() {
        return count_total;
    }

    public void setCount_total(int count_total) {
        this.count_total = count_total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
