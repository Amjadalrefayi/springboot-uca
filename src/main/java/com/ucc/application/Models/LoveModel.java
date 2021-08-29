package com.ucc.application.Models;

import java.util.Objects;

public class LoveModel {

    private Long post_id;

    private String userName;


    public LoveModel() {
    }

    public LoveModel(Long post_id, String userName) {
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

    public LoveModel post_id(Long post_id) {
        setPost_id(post_id);
        return this;
    }

    public LoveModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LoveModel)) {
            return false;
        }
        LoveModel loveModel = (LoveModel) o;
        return Objects.equals(post_id, loveModel.post_id) && Objects.equals(userName, loveModel.userName);
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
