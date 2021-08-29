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
@Table(name = "Replaies")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ReplayEntity {

     /**** Attribute Area ****/

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="Replay_id")
     private Long id;
 
     @Column(name="Replay_Value")
     private String replay_Value;

           
    /**** Relational Attribute ****/

    @ManyToOne
    @JoinColumn(name="user_id" , nullable= false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name="post_id" , nullable= false)
    private PostEntity postEntity;

    @ManyToOne
    @JoinColumn(name="comment_id" , nullable= false)
    private CommentEntity commentEntity;


    public ReplayEntity() {
    }

    public ReplayEntity(Long id, String replay_Value, UserEntity userEntity, PostEntity postEntity, CommentEntity commentEntity) {
        this.id = id;
        this.replay_Value = replay_Value;
        this.userEntity = userEntity;
        this.postEntity = postEntity;
        this.commentEntity = commentEntity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReplay_Value() {
        return this.replay_Value;
    }

    public void setReplay_Value(String replay_Value) {
        this.replay_Value = replay_Value;
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

    public CommentEntity getCommentEntity() {
        return this.commentEntity;
    }

    public void setCommentEntity(CommentEntity commentEntity) {
        this.commentEntity = commentEntity;
    }

    public ReplayEntity id(Long id) {
        setId(id);
        return this;
    }

    public ReplayEntity replay_Value(String replay_Value) {
        setReplay_Value(replay_Value);
        return this;
    }

    public ReplayEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public ReplayEntity postEntity(PostEntity postEntity) {
        setPostEntity(postEntity);
        return this;
    }

    public ReplayEntity commentEntity(CommentEntity commentEntity) {
        setCommentEntity(commentEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReplayEntity)) {
            return false;
        }
        ReplayEntity replayEntity = (ReplayEntity) o;
        return Objects.equals(id, replayEntity.id) && Objects.equals(replay_Value, replayEntity.replay_Value) && Objects.equals(userEntity, replayEntity.userEntity) && Objects.equals(postEntity, replayEntity.postEntity) && Objects.equals(commentEntity, replayEntity.commentEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, replay_Value, userEntity, postEntity, commentEntity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", replay_Value='" + getReplay_Value() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            ", postEntity='" + getPostEntity() + "'" +
            ", commentEntity='" + getCommentEntity() + "'" +
            "}";
    }


    
}
