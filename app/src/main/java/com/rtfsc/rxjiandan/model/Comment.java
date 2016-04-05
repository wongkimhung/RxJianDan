package com.rtfsc.rxjiandan.model;

import java.io.Serializable;

/**
 * Created by kdroid on 16-3-30.
 */
public  class Comment implements Serializable {
    private int id;
    private String name;
    private String url;
    private String date;
    private String content;
    private int parent;
    private int vote_positive;
    private int vote_negative;
    private int index;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getVote_positive() {
        return vote_positive;
    }

    public void setVote_positive(int vote_positive) {
        this.vote_positive = vote_positive;
    }

    public int getVote_negative() {
        return vote_negative;
    }

    public void setVote_negative(int vote_negative) {
        this.vote_negative = vote_negative;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}