package com.ucc.application.Models;


import java.util.List;
import java.util.Objects;

public class PostModel {

    private Long id;
    private String userName;
    private String userImage;
    private String title;
    private String post_Value;
    private String attachment;
    private String created_At;
    private Integer likeCount;
    private Integer loveCount;
    private Integer commnetCount;

    private List<String>users_Make_like;
    private List<String> users_Make_loveReaction;
    private List<CommentModel> commentInfo;
    private List<ReplayModel> replaiesInfo;


    public PostModel() {
    }

    public PostModel(Long id, String userName, String userImage, String title, String post_Value, String attachment, String created_At, Integer likeCount, Integer loveCount, Integer commnetCount, List<String> users_Make_like, List<String> users_Make_loveReaction, List<CommentModel> commentInfo, List<ReplayModel> replaiesInfo) {
        this.id = id;
        this.userName = userName;
        this.userImage = userImage;
        this.title = title;
        this.post_Value = post_Value;
        this.attachment = attachment;
        this.created_At = created_At;
        this.likeCount = likeCount;
        this.loveCount = loveCount;
        this.commnetCount = commnetCount;
        this.users_Make_like = users_Make_like;
        this.users_Make_loveReaction = users_Make_loveReaction;
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

    public Integer getLoveCount() {
        return this.loveCount;
    }

    public void setLoveCount(Integer loveCount) {
        this.loveCount = loveCount;
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

    public List<String> getUsers_Make_loveReaction() {
        return this.users_Make_loveReaction;
    }

    public void setUsers_Make_loveReaction(List<String> users_Make_loveReaction) {
        this.users_Make_loveReaction = users_Make_loveReaction;
    }

    public List<CommentModel> getCommentInfo() {
        return this.commentInfo;
    }

    public void setCommentInfo(List<CommentModel> commentInfo) {
        this.commentInfo = commentInfo;
    }

    public List<ReplayModel> getReplaiesInfo() {
        return this.replaiesInfo;
    }

    public void setReplaiesInfo(List<ReplayModel> replaiesInfo) {
        this.replaiesInfo = replaiesInfo;
    }

    public PostModel id(Long id) {
        setId(id);
        return this;
    }

    public PostModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public PostModel userImage(String userImage) {
        setUserImage(userImage);
        return this;
    }

    public PostModel title(String title) {
        setTitle(title);
        return this;
    }

    public PostModel post_Value(String post_Value) {
        setPost_Value(post_Value);
        return this;
    }

    public PostModel attachment(String attachment) {
        setAttachment(attachment);
        return this;
    }

    public PostModel created_At(String created_At) {
        setCreated_At(created_At);
        return this;
    }

    public PostModel likeCount(Integer likeCount) {
        setLikeCount(likeCount);
        return this;
    }

    public PostModel loveCount(Integer loveCount) {
        setLoveCount(loveCount);
        return this;
    }

    public PostModel commnetCount(Integer commnetCount) {
        setCommnetCount(commnetCount);
        return this;
    }

    public PostModel users_Make_like(List<String> users_Make_like) {
        setUsers_Make_like(users_Make_like);
        return this;
    }

    public PostModel users_Make_loveReaction(List<String> users_Make_loveReaction) {
        setUsers_Make_loveReaction(users_Make_loveReaction);
        return this;
    }

    public PostModel commentInfo(List<CommentModel> commentInfo) {
        setCommentInfo(commentInfo);
        return this;
    }

    public PostModel replaiesInfo(List<ReplayModel> replaiesInfo) {
        setReplaiesInfo(replaiesInfo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PostModel)) {
            return false;
        }
        PostModel postModel = (PostModel) o;
        return Objects.equals(id, postModel.id) && Objects.equals(userName, postModel.userName) && Objects.equals(userImage, postModel.userImage) && Objects.equals(title, postModel.title) && Objects.equals(post_Value, postModel.post_Value) && Objects.equals(attachment, postModel.attachment) && Objects.equals(created_At, postModel.created_At) && Objects.equals(likeCount, postModel.likeCount) && Objects.equals(loveCount, postModel.loveCount) && Objects.equals(commnetCount, postModel.commnetCount) && Objects.equals(users_Make_like, postModel.users_Make_like) && Objects.equals(users_Make_loveReaction, postModel.users_Make_loveReaction) && Objects.equals(commentInfo, postModel.commentInfo) && Objects.equals(replaiesInfo, postModel.replaiesInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userImage, title, post_Value, attachment, created_At, likeCount, loveCount, commnetCount, users_Make_like, users_Make_loveReaction, commentInfo, replaiesInfo);
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
            ", loveCount='" + getLoveCount() + "'" +
            ", commnetCount='" + getCommnetCount() + "'" +
            ", users_Make_like='" + getUsers_Make_like() + "'" +
            ", users_Make_loveReaction='" + getUsers_Make_loveReaction() + "'" +
            ", commentInfo='" + getCommentInfo() + "'" +
            ", replaiesInfo='" + getReplaiesInfo() + "'" +
            "}";
    }

}
