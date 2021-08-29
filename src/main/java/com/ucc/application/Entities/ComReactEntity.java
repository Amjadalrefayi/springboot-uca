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
@Table(name = "comreact")
@JsonIdentityInfo(generator =  ObjectIdGenerators.PropertyGenerator.class,property ="id" )
public class ComReactEntity {

    /**** Attribute Area ****/

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "ComReact_id")
    private Long id;

    
    /**** Relational Attribute ****/

    @ManyToOne
    @JoinColumn(name="user_id" , nullable= false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="comment_id" , nullable= true)
    private CommentEntity commentEntity;



    public ComReactEntity() {
    }

    public ComReactEntity(Long id, UserEntity userEntity, CommentEntity commentEntity) {
        this.id = id;
        this.userEntity = userEntity;
        this.commentEntity = commentEntity;
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

    public CommentEntity getCommentEntity() {
        return this.commentEntity;
    }

    public void setCommentEntity(CommentEntity commentEntity) {
        this.commentEntity = commentEntity;
    }

    public ComReactEntity id(Long id) {
        setId(id);
        return this;
    }

    public ComReactEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public ComReactEntity commentEntity(CommentEntity commentEntity) {
        setCommentEntity(commentEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ComReactEntity)) {
            return false;
        }
        ComReactEntity comReact = (ComReactEntity) o;
        return Objects.equals(id, comReact.id) && Objects.equals(userEntity, comReact.userEntity) && Objects.equals(commentEntity, comReact.commentEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEntity, commentEntity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            ", commentEntity='" + getCommentEntity() + "'" +
            "}";
    }


    
}
