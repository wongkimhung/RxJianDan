package com.rtfsc.rxjiandan.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kdroid on 16-3-29.
 */
public class Post implements Serializable{
    private int id;
    private String url;
    private String title;
    private String date;
    /**
     * id : 550
     * slug : mayan
     * name : mayan
     * first_name : may
     * last_name : an
     * nickname : mayan
     * url :
     * description :
     */

    private Author author;
    private int comment_count;
    private CustomFieldsBean custom_fields;
    /**
     * id : 712
     * slug : meme
     * title : meme
     * description :
     * post_count : 116
     */

    private List<Tag> tags;
    private List<Comment> comments;
    private String content;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public CustomFieldsBean getCustom_fields() {
        return custom_fields;
    }

    public void setCustom_fields(CustomFieldsBean custom_fields) {
        this.custom_fields = custom_fields;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    public static class CustomFieldsBean implements Serializable{
        private List<String> thumb_c;

        public List<String> getThumb_c() {
            return thumb_c;
        }

        public void setThumb_c(List<String> thumb_c) {
            this.thumb_c = thumb_c;
        }
    }

}
