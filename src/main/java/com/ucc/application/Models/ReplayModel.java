package com.ucc.application.Models;

import java.util.Objects;

public class ReplayModel {
    
    private Long replay_id;
    private Long comment_id;
    private Long post_id;
    private String userName;
    private String userImg;
    private String value;



    public ReplayModel() {
    }

    public ReplayModel(Long replay_id, Long comment_id, Long post_id, String userName, String userImg, String value) {
        this.replay_id = replay_id;
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.userName = userName;
        this.userImg = userImg;
        this.value = value;
    }

    public Long getReplay_id() {
        return this.replay_id;
    }

    public void setReplay_id(Long replay_id) {
        this.replay_id = replay_id;
    }

    public Long getComment_id() {
        return this.comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
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

    public String getUserImg() {
        return this.userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ReplayModel replay_id(Long replay_id) {
        setReplay_id(replay_id);
        return this;
    }

    public ReplayModel comment_id(Long comment_id) {
        setComment_id(comment_id);
        return this;
    }

    public ReplayModel post_id(Long post_id) {
        setPost_id(post_id);
        return this;
    }

    public ReplayModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public ReplayModel userImg(String userImg) {
        setUserImg(userImg);
        return this;
    }

    public ReplayModel value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReplayModel)) {
            return false;
        }
        ReplayModel replayModel = (ReplayModel) o;
        return Objects.equals(replay_id, replayModel.replay_id) && Objects.equals(comment_id, replayModel.comment_id) && Objects.equals(post_id, replayModel.post_id) && Objects.equals(userName, replayModel.userName) && Objects.equals(userImg, replayModel.userImg) && Objects.equals(value, replayModel.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replay_id, comment_id, post_id, userName, userImg, value);
    }

    @Override
    public String toString() {
        return "{" +
            " replay_id='" + getReplay_id() + "'" +
            ", comment_id='" + getComment_id() + "'" +
            ", post_id='" + getPost_id() + "'" +
            ", userName='" + getUserName() + "'" +
            ", userImg='" + getUserImg() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }

}
