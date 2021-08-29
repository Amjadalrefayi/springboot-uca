package com.ucc.application.Models;


import java.util.List;
import java.util.Objects;

public class PostPCModel {

    private Long id;
    private String userName;
    private String userImage;
    private String title;
    private String post_Value;
    private String attachment;
    private String created_At;
    private Integer likeCount;
    private Integer commnetCount;

    private List<String>users_Make_like;
    private List<CommentPCModel> commentInfo;
    private List<ReplayPCModel> replaiesInfo;


    public PostPCModel() {
    }

    public PostPCModel(Long id, String userName, String userImage, String title, String post_Value, String attachment, String created_At, Integer likeCount, Integer commnetCount, List<String> users_Make_like, List<CommentPCModel> commentInfo, List<ReplayPCModel> replaiesInfo) {
        this.id = id;
        this.userName = userName;
        this.userImage = userImage;
        this.title = title;
        this.post_Value = post_Value;
        this.attachment = attachment;
        this.created_At = created_At;
        this.likeCount = likeCount;
        this.commnetCount = commnetCount;
        this.users_Make_like = users_Make_like;
        this.commentInfo = commentInfo;
        this.replaiesInfo = replaiesInfo;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost_Value() {
        return this.post_Value;
    }

    public void setPost_Value(String post_Value) {
        this.post_Value = post_Value;
    }

    public String getAttachment() {
        return this.attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getCreated_At() {
        return this.created_At;
    }

    public void setCreated_At(String created_At) {
        this.created_At = created_At;
    }

    public Integer getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommnetCount() {
        return this.commnetCount;
    }

    public void setCommnetCount(Integer commnetCount) {
        this.commnetCount = commnetCount;
    }

    public List<String> getUsers_Make_like() {
        return this.users_Make_like;
    }

    public void setUsers_Make_like(List<String> users_Make_like) {
        this.users_Make_like = users_Make_like;
    }

    public List<CommentPCModel> getCommentInfo() {
        return this.commentInfo;
    }

    public void setCommentInfo(List<CommentPCModel> commentInfo) {
        this.commentInfo = commentInfo;
    }

    public List<ReplayPCModel> getReplaiesInfo() {
        return this.replaiesInfo;
    }

    public void setReplaiesInfo(List<ReplayPCModel> replaiesInfo) {
        this.replaiesInfo = replaiesInfo;
    }

    public PostPCModel id(Long id) {
        setId(id);
        return this;
    }

    public PostPCModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public PostPCModel userImage(String userImage) {
        setUserImage(userImage);
        return this;
    }

    public PostPCModel title(String title) {
        setTitle(title);
        return this;
    }

    public PostPCModel post_Value(String post_Value) {
        setPost_Value(post_Value);
        return this;
    }

    public PostPCModel attachment(String attachment) {
        setAttachment(attachment);
        return this;
    }

    public PostPCModel created_At(String created_At) {
        setCreated_At(created_At);
        return this;
    }

    public PostPCModel likeCount(Integer likeCount) {
        setLikeCount(likeCount);
        return this;
    }

    public PostPCModel commnetCount(Integer commnetCount) {
        setCommnetCount(commnetCount);
        return this;
    }

    public PostPCModel users_Make_like(List<String> users_Make_like) {
        setUsers_Make_like(users_Make_like);
        return this;
    }

    public PostPCModel commentInfo(List<CommentPCModel> commentInfo) {
        setCommentInfo(commentInfo);
        return this;
    }

    public PostPCModel replaiesInfo(List<ReplayPCModel> replaiesInfo) {
        setReplaiesInfo(replaiesInfo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PostPCModel)) {
            return false;
        }
        PostPCModel postPCModel = (PostPCModel) o;
        return Objects.equals(id, postPCModel.id) && Objects.equals(userName, postPCModel.userName) && Objects.equals(userImage, postPCModel.userImage) && Objects.equals(title, postPCModel.title) && Objects.equals(post_Value, postPCModel.post_Value) && Objects.equals(attachment, postPCModel.attachment) && Objects.equals(created_At, postPCModel.created_At) && Objects.equals(likeCount, postPCModel.likeCount) && Objects.equals(commnetCount, postPCModel.commnetCount) && Objects.equals(users_Make_like, postPCModel.users_Make_like) && Objects.equals(commentInfo, postPCModel.commentInfo) && Objects.equals(replaiesInfo, postPCModel.replaiesInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userImage, title, post_Value, attachment, created_At, likeCount, commnetCount, users_Make_like, commentInfo, replaiesInfo);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", userImage='" + getUserImage() + "'" +
            ", title='" + getTitle() + "'" +
            ", post_Value='" + getPost_Value() + "'" +
            ", attachment='" + getAttachment() + "'" +
            ", created_At='" + getCreated_At() + "'" +
            ", likeCount='" + getLikeCount() + "'" +
            ", commnetCount='" + getCommnetCount() + "'" +
            ", users_Make_like='" + getUsers_Make_like() + "'" +
            ", commentInfo='" + getCommentInfo() + "'" +
            ", replaiesInfo='" + getReplaiesInfo() + "'" +
            "}";
    }

}
