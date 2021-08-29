package com.ucc.application.Models;

import java.util.List;
import java.util.Objects;



public class UserModel {

   private Long user_id;
   private Long community_id;
   private String firstName;
   private String lastName;
   private String userName;
   private String email;
   private String password;
   private String university;
   private String specialize;
   private Integer study_Year;
   private Integer age;
   private boolean online;
   private String created_At;
   private String image;
   private String cover;

   List<PostModel>posts;
   List<CommentModel> comments;
   List<LikeModel>likes;
   List<LoveModel>loves;
   List<ReplayModel> replaies;
   List<StoryModel> stories;

    public UserModel() {
    }

    public UserModel(Long user_id, Long community_id, String firstName, String lastName, String userName, String email, String password, String university, String specialize, Integer study_Year, Integer age, boolean online, String created_At, String image, String cover, List<PostModel> posts, List<CommentModel> comments, List<LikeModel> likes, List<LoveModel> loves, List<ReplayModel> replaies, List<StoryModel> stories) {
        this.user_id = user_id;
        this.community_id = community_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.university = university;
        this.specialize = specialize;
        this.study_Year = study_Year;
        this.age = age;
        this.online = online;
        this.created_At = created_At;
        this.image = image;
        this.cover = cover;
        this.posts = posts;
        this.comments = comments;
        this.likes = likes;
        this.loves = loves;
        this.replaies = replaies;
        this.stories = stories;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getCommunity_id() {
        return this.community_id;
    }

    public void setCommunity_id(Long community_id) {
        this.community_id = community_id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniversity() {
        return this.university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpecialize() {
        return this.specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public Integer getStudy_Year() {
        return this.study_Year;
    }

    public void setStudy_Year(Integer study_Year) {
        this.study_Year = study_Year;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isOnline() {
        return this.online;
    }

    public boolean getOnline() {
        return this.online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getCreated_At() {
        return this.created_At;
    }

    public void setCreated_At(String created_At) {
        this.created_At = created_At;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<PostModel> getPosts() {
        return this.posts;
    }

    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }

    public List<CommentModel> getComments() {
        return this.comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public List<LikeModel> getLikes() {
        return this.likes;
    }

    public void setLikes(List<LikeModel> likes) {
        this.likes = likes;
    }

    public List<LoveModel> getLoves() {
        return this.loves;
    }

    public void setLoves(List<LoveModel> loves) {
        this.loves = loves;
    }

    public List<ReplayModel> getReplaies() {
        return this.replaies;
    }

    public void setReplaies(List<ReplayModel> replaies) {
        this.replaies = replaies;
    }

    public List<StoryModel> getStories() {
        return this.stories;
    }

    public void setStories(List<StoryModel> stories) {
        this.stories = stories;
    }

    public UserModel user_id(Long user_id) {
        setUser_id(user_id);
        return this;
    }

    public UserModel community_id(Long community_id) {
        setCommunity_id(community_id);
        return this;
    }

    public UserModel firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UserModel lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UserModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public UserModel email(String email) {
        setEmail(email);
        return this;
    }

    public UserModel password(String password) {
        setPassword(password);
        return this;
    }

    public UserModel university(String university) {
        setUniversity(university);
        return this;
    }

    public UserModel specialize(String specialize) {
        setSpecialize(specialize);
        return this;
    }

    public UserModel study_Year(Integer study_Year) {
        setStudy_Year(study_Year);
        return this;
    }

    public UserModel age(Integer age) {
        setAge(age);
        return this;
    }

    public UserModel online(boolean online) {
        setOnline(online);
        return this;
    }

    public UserModel created_At(String created_At) {
        setCreated_At(created_At);
        return this;
    }

    public UserModel image(String image) {
        setImage(image);
        return this;
    }

    public UserModel cover(String cover) {
        setCover(cover);
        return this;
    }

    public UserModel posts(List<PostModel> posts) {
        setPosts(posts);
        return this;
    }

    public UserModel comments(List<CommentModel> comments) {
        setComments(comments);
        return this;
    }

    public UserModel likes(List<LikeModel> likes) {
        setLikes(likes);
        return this;
    }

    public UserModel loves(List<LoveModel> loves) {
        setLoves(loves);
        return this;
    }

    public UserModel replaies(List<ReplayModel> replaies) {
        setReplaies(replaies);
        return this;
    }

    public UserModel stories(List<StoryModel> stories) {
        setStories(stories);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(user_id, userModel.user_id) && Objects.equals(community_id, userModel.community_id) && Objects.equals(firstName, userModel.firstName) && Objects.equals(lastName, userModel.lastName) && Objects.equals(userName, userModel.userName) && Objects.equals(email, userModel.email) && Objects.equals(password, userModel.password) && Objects.equals(university, userModel.university) && Objects.equals(specialize, userModel.specialize) && Objects.equals(study_Year, userModel.study_Year) && Objects.equals(age, userModel.age) && online == userModel.online && Objects.equals(created_At, userModel.created_At) && Objects.equals(image, userModel.image) && Objects.equals(cover, userModel.cover) && Objects.equals(posts, userModel.posts) && Objects.equals(comments, userModel.comments) && Objects.equals(likes, userModel.likes) && Objects.equals(loves, userModel.loves) && Objects.equals(replaies, userModel.replaies) && Objects.equals(stories, userModel.stories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, community_id, firstName, lastName, userName, email, password, university, specialize, study_Year, age, online, created_At, image, cover, posts, comments, likes, loves, replaies, stories);
    }

    @Override
    public String toString() {
        return "{" +
            " user_id='" + getUser_id() + "'" +
            ", community_id='" + getCommunity_id() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", university='" + getUniversity() + "'" +
            ", specialize='" + getSpecialize() + "'" +
            ", study_Year='" + getStudy_Year() + "'" +
            ", age='" + getAge() + "'" +
            ", online='" + isOnline() + "'" +
            ", created_At='" + getCreated_At() + "'" +
            ", image='" + getImage() + "'" +
            ", cover='" + getCover() + "'" +
            ", posts='" + getPosts() + "'" +
            ", comments='" + getComments() + "'" +
            ", likes='" + getLikes() + "'" +
            ", loves='" + getLoves() + "'" +
            ", replaies='" + getReplaies() + "'" +
            ", stories='" + getStories() + "'" +
            "}";
    }

}
