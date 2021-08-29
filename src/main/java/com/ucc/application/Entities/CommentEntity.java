package com.ucc.application.Entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Comments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CommentEntity {

    /**** Attribute Area ****/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Comment_id")
    private Long id;

    @Column(name="Comment_Value")
    private String comment_Value;


        
    /**** Relational Attribute ****/

    @ManyToOne
    @JoinColumn(name="user_id" , nullable= false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="post_id" , nullable= false)
    private PostEntity postEntity;

    @OneToMany(mappedBy = "commentEntity",cascade = CascadeType.ALL)
    private List<ReplayEntity> comment_Replaies;

    @OneToMany(mappedBy = "commentEntity",cascade = CascadeType.ALL)
    private List<ComReactEntity> comment_Reactions;


    public CommentEntity() {
    }

    public CommentEntity(Long id, String comment_Value, UserEntity userEntity, PostEntity postEntity, List<ReplayEntity> comment_Replaies, List<ComReactEntity> comment_Reactions) {
        this.id = id;
        this.comment_Value = comment_Value;
        this.userEntity = userEntity;
        this.postEntity = postEntity;
        this.comment_Replaies = comment_Replaies;
        this.comment_Reactions = comment_Reactions;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment_Value() {
        return this.comment_Value;
    }

    public void setComment_Value(String comment_Value) {
        this.comment_Value = comment_Value;
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

    public List<ReplayEntity> getComment_Replaies() {
        return this.comment_Replaies;
    }

    public void setComment_Replaies(List<ReplayEntity> comment_Replaies) {
        this.comment_Replaies = comment_Replaies;
    }

    public List<ComReactEntity> getComment_Reactions() {
        return this.comment_Reactions;
    }

    public void setComment_Reactions(List<ComReactEntity> comment_Reactions) {
        this.comment_Reactions = comment_Reactions;
    }

    public CommentEntity id(Long id) {
        setId(id);
        return this;
    }

    public CommentEntity comment_Value(String comment_Value) {
        setComment_Value(comment_Value);
        return this;
    }

    public CommentEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public CommentEntity postEntity(PostEntity postEntity) {
        setPostEntity(postEntity);
        return this;
    }

    public CommentEntity comment_Replaies(List<ReplayEntity> comment_Replaies) {
        setComment_Replaies(comment_Replaies);
        return this;
    }

    public CommentEntity comment_Reactions(List<ComReactEntity> comment_Reactions) {
        setComment_Reactions(comment_Reactions);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommentEntity)) {
            return false;
        }
        CommentEntity commentEntity = (CommentEntity) o;
        return Objects.equals(id, commentEntity.id) && Objects.equals(comment_Value, commentEntity.comment_Value) && Objects.equals(userEntity, commentEntity.userEntity) && Objects.equals(postEntity, commentEntity.postEntity) && Objects.equals(comment_Replaies, commentEntity.comment_Replaies) && Objects.equals(comment_Reactions, commentEntity.comment_Reactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment_Value, userEntity, postEntity, comment_Replaies, comment_Reactions);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", comment_Value='" + getComment_Value() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            ", postEntity='" + getPostEntity() + "'" +
            ", comment_Replaies='" + getComment_Replaies() + "'" +
            ", comment_Reactions='" + getComment_Reactions() + "'" +
            "}";
    }

}
