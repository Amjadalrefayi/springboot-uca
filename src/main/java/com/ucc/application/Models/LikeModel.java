package com.ucc.application.Models;

import java.util.Objects;

public class LikeModel {

    private Long post_id;

    private String userName;


    public LikeModel() {
    }

    public LikeModel(Long post_id, String userName) {
        this.post_id = post_id;
        this.userName = userName;
    }

    public Long getPost_id() {
        return this.post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LikeModel post_id(Long post_id) {
        setPost_id(post_id);
        return this;
    }

    public LikeModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LikeModel)) {
            return false;
        }
        LikeModel likeModel = (LikeModel) o;
        return Objects.equals(post_id, likeModel.post_id) && Objects.equals(userName, likeModel.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post_id, userName);
    }

    @Override
    public String toString() {
        return "{" +
            " post_id='" + getPost_id() + "'" +
            ", userName='" + getUserName() + "'" +
            "}";
    }

    
}
