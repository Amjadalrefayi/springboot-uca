package com.ucc.application.Models;

import java.util.Objects;

public class ComReactPCModel {

    private Long comment_id;
    private String userName;
    private String userImage;


    public ComReactPCModel() {
    }

    public ComReactPCModel(Long comment_id, String userName, String userImage) {
        this.comment_id = comment_id;
        this.userName = userName;
        this.userImage = userImage;
    }

    public Long getComment_id() {
        return this.comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
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

    public ComReactPCModel comment_id(Long comment_id) {
        setComment_id(comment_id);
        return this;
    }

    public ComReactPCModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public ComReactPCModel userImage(String userImage) {
        setUserImage(userImage);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ComReactPCModel)) {
            return false;
        }
        ComReactPCModel comReactPCModel = (ComReactPCModel) o;
        return Objects.equals(comment_id, comReactPCModel.comment_id) && Objects.equals(userName, comReactPCModel.userName) && Objects.equals(userImage, comReactPCModel.userImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id, userName, userImage);
    }

    @Override
    public String toString() {
        return "{" +
            " comment_id='" + getComment_id() + "'" +
            ", userName='" + getUserName() + "'" +
            ", userImage='" + getUserImage() + "'" +
            "}";
    }

}
