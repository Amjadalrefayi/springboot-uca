package com.ucc.application.Entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Likes")
@JsonIdentityInfo(generator =  ObjectIdGenerators.PropertyGenerator.class,property ="id" )
public class LikeEntity {

    /**** Attribute Area ****/

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "Like_id")
    private Long id;


    /**** Relational Attribute ****/

    @ManyToOne
    @JoinColumn(name="user_id" , nullable= false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="post_id" , nullable= true)
    private PostEntity postEntity;

    // @ManyToOne
    // @JoinColumn(name="comment_id" , nullable= true)
    // private CommentEntity commentEntity;


    public LikeEntity() {
    }

    public LikeEntity(Long id, UserEntity userEntity, PostEntity postEntity) {
        this.id = id;
        this.userEntity = userEntity;
        this.postEntity = postEntity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public PostEntity getPostEntity() {
        return this.postEntity;
    }

    public void setPostEntity(PostEntity postEntity) {
        this.postEntity = postEntity;
    }

    public LikeEntity id(Long id) {
        setId(id);
        return this;
    }

    public LikeEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public LikeEntity postEntity(PostEntity postEntity) {
        setPostEntity(postEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LikeEntity)) {
            return false;
        }
        LikeEntity likeEntity = (LikeEntity) o;
        return Objects.equals(id, likeEntity.id) && Objects.equals(userEntity, likeEntity.userEntity) && Objects.equals(postEntity, likeEntity.postEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEntity, postEntity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            ", postEntity='" + getPostEntity() + "'" +
            "}";
    }


    
}
