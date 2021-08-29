package com.ucc.application.Models;

import java.util.List;
import java.util.Objects;

public class CommentPCModel {

    private Long post_id;
    private Long comment_id;
    private String userName;
    private String userImg;
    private String value;
    private Integer reactions;
    private Integer replaiesCount;

    List<ComReactPCModel> comReacts;


    public CommentPCModel() {
    }

    public CommentPCModel(Long post_id, Long comment_id, String userName, String userImg, String value, Integer reactions, Integer replaiesCount, List<ComReactPCModel> comReacts) {
        this.post_id = post_id;
        this.comment_id = comment_id;
        this.userName = userName;
        this.userImg = userImg;
        this.value = value;
        this.reactions = reactions;
        this.replaiesCount = replaiesCount;
        this.comReacts = comReacts;
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

    public List<ComReactPCModel> getComReacts() {
        return this.comReacts;
    }

    public void setComReacts(List<ComReactPCModel> comReacts) {
        this.comReacts = comReacts;
    }

    public CommentPCModel post_id(Long post_id) {
        setPost_id(post_id);
        return this;
    }

    public CommentPCModel comment_id(Long comment_id) {
        setComment_id(comment_id);
        return this;
    }

    public CommentPCModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public CommentPCModel userImg(String userImg) {
        setUserImg(userImg);
        return this;
    }

    public CommentPCModel value(String value) {
        setValue(value);
        return this;
    }

    public CommentPCModel reactions(Integer reactions) {
        setReactions(reactions);
        return this;
    }

    public CommentPCModel replaiesCount(Integer replaiesCount) {
        setReplaiesCount(replaiesCount);
        return this;
    }

    public CommentPCModel comReacts(List<ComReactPCModel> comReacts) {
        setComReacts(comReacts);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommentPCModel)) {
            return false;
        }
        CommentPCModel commentPCModel = (CommentPCModel) o;
        return Objects.equals(post_id, commentPCModel.post_id) && Objects.equals(comment_id, commentPCModel.comment_id) && Objects.equals(userName, commentPCModel.userName) && Objects.equals(userImg, commentPCModel.userImg) && Objects.equals(value, commentPCModel.value) && Objects.equals(reactions, commentPCModel.reactions) && Objects.equals(replaiesCount, commentPCModel.replaiesCount) && Objects.equals(comReacts, commentPCModel.comReacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post_id, comment_id, userName, userImg, value, reactions, replaiesCount, comReacts);
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
            "}";
    }

}
