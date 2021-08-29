package com.ucc.application.Models;

import java.util.List;
import java.util.Objects;



public class CommunityModel {
    
    private String name;
    private String descreption;
    private String image;

    private List<String> userName;


    public CommunityModel() {
    }

    public CommunityModel(String name, String descreption, String image, List<String> userName) {
        this.name = name;
        this.descreption = descreption;
        this.image = image;
        this.userName = userName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescreption() {
        return this.descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getUserName() {
        return this.userName;
    }

    public void setUserName(List<String> userName) {
        this.userName = userName;
    }

    public CommunityModel name(String name) {
        setName(name);
        return this;
    }

    public CommunityModel descreption(String descreption) {
        setDescreption(descreption);
        return this;
    }

    public CommunityModel image(String image) {
        setImage(image);
        return this;
    }

    public CommunityModel userName(List<String> userName) {
        setUserName(userName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommunityModel)) {
            return false;
        }
        CommunityModel communityModel = (CommunityModel) o;
        return Objects.equals(name, communityModel.name) && Objects.equals(descreption, communityModel.descreption) && Objects.equals(image, communityModel.image) && Objects.equals(userName, communityModel.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, descreption, image, userName);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", descreption='" + getDescreption() + "'" +
            ", image='" + getImage() + "'" +
            ", userName='" + getUserName() + "'" +
            "}";
    }



}
