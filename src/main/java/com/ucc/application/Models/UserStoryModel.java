package com.ucc.application.Models;

import java.util.List;
import java.util.Objects;

public class UserStoryModel {

    private String userName;
    private String userImg;

    private List<StoryModel> stories;


    public UserStoryModel() {
    }

    public UserStoryModel(String userName, String userImg, List<StoryModel> stories) {
        this.userName = userName;
        this.userImg = userImg;
        this.stories = stories;
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

    public List<StoryModel> getStories() {
        return this.stories;
    }

    public void setStories(List<StoryModel> stories) {
        this.stories = stories;
    }

    public UserStoryModel userName(String userName) {
        setUserName(userName);
        return this;
    }

    public UserStoryModel userImg(String userImg) {
        setUserImg(userImg);
        return this;
    }

    public UserStoryModel stories(List<StoryModel> stories) {
        setStories(stories);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserStoryModel)) {
            return false;
        }
        UserStoryModel userStoryModel = (UserStoryModel) o;
        return Objects.equals(userName, userStoryModel.userName) && Objects.equals(userImg, userStoryModel.userImg) && Objects.equals(stories, userStoryModel.stories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userImg, stories);
    }

    @Override
    public String toString() {
        return "{" +
            " userName='" + getUserName() + "'" +
            ", userImg='" + getUserImg() + "'" +
            ", stories='" + getStories() + "'" +
            "}";
    }
    
    
    
}
