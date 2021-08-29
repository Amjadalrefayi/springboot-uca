package com.ucc.application.Models;

import java.util.List;
import java.util.Objects;

public class CommentModel {

    private Long post_id;
    private Long comment_id;
    private String userName;
    private String userImg;
    private String value;
    private Integer reactions;
    private Integer replaiesCount;


    List<ComReactModel> comReacts;
    List<ReplayModel> replaies;


    public CommentModel() {
    }

    public CommentModel(Long post_id, Long comment_id, String userName, String userImg, String value, Integer reactions, Integer replaiesCount, List<ComReactModel> comReacts, List<ReplayModel> replaies) {
        this.post_id = post_id;
        this.comment_id = comment_id;
        this.userName = userName;
        this.userImg = userImg;
        this.value = value;
        this.reactions = reactions;
        this.replaiesCount = replaiesCount;
        this.comReacts = comReacts;
        this.replaies = replaies;
    }

    public Long getPost_id() {
        return this.post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
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

    public Integer getReactions() {
        return this.reactions;
    }

    public void setReactions(Integer reactions) {
        this.reactions = reactions;
    }

    public Integer getReplaiesCount() {
        return this.replaiesCount;
    }

    public void setReplaiesCount(Integer replaiesCount) {
        this.replaiesCount = replaiesCount;
    }

    public List<ComReactModel> getComReacts() {
        return this.comReacts;
    }

    public void setComReacts(List<ComReactModel> comReacts) {
        this.comReacts = comReacts;
    }

    public List<ReplayModel> getReplaies() {
        return this.replaies;
    }

    public void setReplaies(List<ReplayModel> replaies) {
        this.replaies = replaies;
    }

    public CommentModel post_id(Long post_id) {
        setPost_id(post_id);
        return this;
    }

    public CommentModel comment_id(Long comment_id) {
        setComment_id(comment_id);
        return this;
    }

    public CommentModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public CommentModel userImg(String userImg) {
        setUserImg(userImg);
        return this;
    }

    public CommentModel value(String value) {
        setValue(value);
        return this;
    }

    public CommentModel reactions(Integer reactions) {
        setReactions(reactions);
        return this;
    }

    public CommentModel replaiesCount(Integer replaiesCount) {
        setReplaiesCount(replaiesCount);
        return this;
    }

    public CommentModel comReacts(List<ComReactModel> comReacts) {
        setComReacts(comReacts);
        return this;
    }

    public CommentModel replaies(List<ReplayModel> replaies) {
        setReplaies(replaies);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommentModel)) {
            return false;
        }
        CommentModel commentModel = (CommentModel) o;
        return Objects.equals(post_id, commentModel.post_id) && Objects.equals(comment_id, commentModel.comment_id) && Objects.equals(userName, commentModel.userName) && Objects.equals(userImg, commentModel.userImg) && Objects.equals(value, commentModel.value) && Objects.equals(reactions, commentModel.reactions) && Objects.equals(replaiesCount, commentModel.replaiesCount) && Objects.equals(comReacts, commentModel.comReacts) && Objects.equals(replaies, commentModel.replaies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post_id, comment_id, userName, userImg, value, reactions, replaiesCount, comReacts, replaies);
    }

    @Override
    public String toString() {
        return "{" +
            " post_id='" + getPost_id() + "'" +
            ", comment_id='" + getComment_id() + "'" +
            ", userName='" + getUserName() + "'" +
            ", userImg='" + getUserImg() + "'" +
            ", value='" + getValue() + "'" +
            ", reactions='" + getReactions() + "'" +
            ", replaiesCount='" + getReplaiesCount() + "'" +
            ", comReacts='" + getComReacts() + "'" +
            ", replaies='" + getReplaies() + "'" +
            "}";
    }

}
