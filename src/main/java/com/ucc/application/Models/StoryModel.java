package com.ucc.application.Models;

import java.util.Objects;

public class StoryModel {

    private Long id;
    private String userName;
    private String userImage;
    private String text;
    private String image;
    private String created_at;


    public StoryModel() {
    }

    public StoryModel(Long id, String userName, String userImage, String text, String image, String created_at) {
        this.id = id;
        this.userName = userName;
        this.userImage = userImage;
        this.text = text;
        this.image = image;
        this.created_at = created_at;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return this.userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public StoryModel id(Long id) {
        setId(id);
        return this;
    }

    public StoryModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public StoryModel userImage(String userImage) {
        setUserImage(userImage);
        return this;
    }

    public StoryModel text(String text) {
        setText(text);
        return this;
    }

    public StoryModel image(String image) {
        setImage(image);
        return this;
    }

    public StoryModel created_at(String created_at) {
        setCreated_at(created_at);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StoryModel)) {
            return false;
        }
        StoryModel storyModel = (StoryModel) o;
        return Objects.equals(id, storyModel.id) && Objects.equals(userName, storyModel.userName) && Objects.equals(userImage, storyModel.userImage) && Objects.equals(text, storyModel.text) && Objects.equals(image, storyModel.image) && Objects.equals(created_at, storyModel.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userImage, text, image, created_at);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", userImage='" + getUserImage() + "'" +
            ", text='" + getText() + "'" +
            ", image='" + getImage() + "'" +
            ", created_at='" + getCreated_at() + "'" +
            "}";
    }

    
}
