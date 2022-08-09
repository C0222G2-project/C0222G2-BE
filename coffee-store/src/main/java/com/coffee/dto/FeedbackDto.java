package com.coffee.dto;

import java.sql.Date;

/**
 * Created by: DiepTT
 * Date created: 09/08/2022
 * Function: Create feedback (User send feedback)
 */

public class FeedbackDto {

    private Integer id;

    private String code;

    private String creator;

    private String email;

    private String content;

    private Integer rating;

    private Date feedbackDate;

    private String image;

    private Boolean isDeleted;

    public FeedbackDto() {
    }

    public FeedbackDto(Integer id, String code, String creator, String email,
                       String content, Integer rating, Date feedbackDate, String image, Boolean isDeleted) {
        this.id = id;
        this.code = code;
        this.creator = creator;
        this.email = email;
        this.content = content;
        this.rating = rating;
        this.feedbackDate = feedbackDate;
        this.image = image;
        this.isDeleted = isDeleted;
    }

    public FeedbackDto(String code, String creator, String email, String content,
                       Integer rating, Date feedbackDate, String image) {
        this.code = code;
        this.creator = creator;
        this.email = email;
        this.content = content;
        this.rating = rating;
        this.feedbackDate = feedbackDate;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
