package com.ucc.application.Entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "communities")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class CommunityEntity {

    /**** Attribute Area ****/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="community_id")
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="image")
    private String image;
    
    @Column(name ="description")
    private String description;


    /**** Relational Attribute ****/

    @OneToMany(mappedBy = "communityEntity")
    List<UserEntity> users;

    @OneToMany(mappedBy = "communityEntity")
    List<PostComuEntity> posts;

    public CommunityEntity() {
    }

    public CommunityEntity(Long id, String name, String image, String description, List<UserEntity> users, List<PostComuEntity> posts) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.users = users;
        this.posts = posts;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserEntity> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public List<PostComuEntity> getPosts() {
        return this.posts;
    }

    public void setPosts(List<PostComuEntity> posts) {
        this.posts = posts;
    }

    public CommunityEntity id(Long id) {
        setId(id);
        return this;
    }

    public CommunityEntity name(String name) {
        setName(name);
        return this;
    }

    public CommunityEntity image(String image) {
        setImage(image);
        return this;
    }

    public CommunityEntity description(String description) {
        setDescription(description);
        return this;
    }

    public CommunityEntity users(List<UserEntity> users) {
        setUsers(users);
        return this;
    }

    public CommunityEntity posts(List<PostComuEntity> posts) {
        setPosts(posts);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommunityEntity)) {
            return false;
        }
        CommunityEntity communityEntity = (CommunityEntity) o;
        return Objects.equals(id, communityEntity.id) && Objects.equals(name, communityEntity.name) && Objects.equals(image, communityEntity.image) && Objects.equals(description, communityEntity.description) && Objects.equals(users, communityEntity.users) && Objects.equals(posts, communityEntity.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, description, users, posts);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", image='" + getImage() + "'" +
            ", description='" + getDescription() + "'" +
            ", users='" + getUsers() + "'" +
            ", posts='" + getPosts() + "'" +
            "}";
    }



    
}
