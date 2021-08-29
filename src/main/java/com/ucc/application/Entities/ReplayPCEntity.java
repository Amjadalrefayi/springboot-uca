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
@Table(name = "ReplaiesPC")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ReplayPCEntity {

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
   @JoinColumn(name="PostCom_id" , nullable= false)
   private PostComuEntity postComuEntity;

   @ManyToOne
   @JoinColumn(name="comment_id" , nullable= false)
   private CommnetPCEntity commnetPCEntity;


    public ReplayPCEntity() {
    }

    public ReplayPCEntity(Long id, String replay_Value, UserEntity userEntity, PostComuEntity postComuEntity, CommnetPCEntity commnetPCEntity) {
        this.id = id;
        this.replay_Value = replay_Value;
        this.userEntity = userEntity;
        this.postComuEntity = postComuEntity;
        this.commnetPCEntity = commnetPCEntity;
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

    public PostComuEntity getPostComuEntity() {
        return this.postComuEntity;
    }

    public void setPostComuEntity(PostComuEntity postComuEntity) {
        this.postComuEntity = postComuEntity;
    }

    public CommnetPCEntity getCommnetPCEntity() {
        return this.commnetPCEntity;
    }

    public void setCommnetPCEntity(CommnetPCEntity commnetPCEntity) {
        this.commnetPCEntity = commnetPCEntity;
    }

    public ReplayPCEntity id(Long id) {
        setId(id);
        return this;
    }

    public ReplayPCEntity replay_Value(String replay_Value) {
        setReplay_Value(replay_Value);
        return this;
    }

    public ReplayPCEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public ReplayPCEntity postComuEntity(PostComuEntity postComuEntity) {
        setPostComuEntity(postComuEntity);
        return this;
    }

    public ReplayPCEntity commnetPCEntity(CommnetPCEntity commnetPCEntity) {
        setCommnetPCEntity(commnetPCEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReplayPCEntity)) {
            return false;
        }
        ReplayPCEntity replayPCEntity = (ReplayPCEntity) o;
        return Objects.equals(id, replayPCEntity.id) && Objects.equals(replay_Value, replayPCEntity.replay_Value) && Objects.equals(userEntity, replayPCEntity.userEntity) && Objects.equals(postComuEntity, replayPCEntity.postComuEntity) && Objects.equals(commnetPCEntity, replayPCEntity.commnetPCEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, replay_Value, userEntity, postComuEntity, commnetPCEntity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", replay_Value='" + getReplay_Value() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            ", postComuEntity='" + getPostComuEntity() + "'" +
            ", commnetPCEntity='" + getCommnetPCEntity() + "'" +
            "}";
    }

    
}
