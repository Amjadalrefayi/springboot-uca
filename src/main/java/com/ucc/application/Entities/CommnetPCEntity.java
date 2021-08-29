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
@Table(name = "CommentsPC")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CommnetPCEntity {

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
     @JoinColumn(name="PostCom_id" , nullable= true)
     private PostComuEntity postComuEntity;
 
     @OneToMany(mappedBy = "commnetPCEntity",cascade = CascadeType.ALL)
     private List<ReplayPCEntity> comment_Replaies;
 
     @OneToMany(mappedBy = "commnetPCEntity",cascade = CascadeType.ALL)
     private List<ComReactPCEntity> comment_Reactions;

    public CommnetPCEntity() {
    }

    public CommnetPCEntity(Long id, String comment_Value, UserEntity userEntity, PostComuEntity postComuEntity, List<ReplayPCEntity> comment_Replaies, List<ComReactPCEntity> comment_Reactions) {
        this.id = id;
        this.comment_Value = comment_Value;
        this.userEntity = userEntity;
        this.postComuEntity = postComuEntity;
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

    public PostComuEntity getPostComuEntity() {
        return this.postComuEntity;
    }

    public void setPostComuEntity(PostComuEntity postComuEntity) {
        this.postComuEntity = postComuEntity;
    }

    public List<ReplayPCEntity> getComment_Replaies() {
        return this.comment_Replaies;
    }

    public void setComment_Replaies(List<ReplayPCEntity> comment_Replaies) {
        this.comment_Replaies = comment_Replaies;
    }

    public List<ComReactPCEntity> getComment_Reactions() {
        return this.comment_Reactions;
    }

    public void setComment_Reactions(List<ComReactPCEntity> comment_Reactions) {
        this.comment_Reactions = comment_Reactions;
    }

    public CommnetPCEntity id(Long id) {
        setId(id);
        return this;
    }

    public CommnetPCEntity comment_Value(String comment_Value) {
        setComment_Value(comment_Value);
        return this;
    }

    public CommnetPCEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public CommnetPCEntity postComuEntity(PostComuEntity postComuEntity) {
        setPostComuEntity(postComuEntity);
        return this;
    }

    public CommnetPCEntity comment_Replaies(List<ReplayPCEntity> comment_Replaies) {
        setComment_Replaies(comment_Replaies);
        return this;
    }

    public CommnetPCEntity comment_Reactions(List<ComReactPCEntity> comment_Reactions) {
        setComment_Reactions(comment_Reactions);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommnetPCEntity)) {
            return false;
        }
        CommnetPCEntity commnetPCEntity = (CommnetPCEntity) o;
        return Objects.equals(id, commnetPCEntity.id) && Objects.equals(comment_Value, commnetPCEntity.comment_Value) && Objects.equals(userEntity, commnetPCEntity.userEntity) && Objects.equals(postComuEntity, commnetPCEntity.postComuEntity) && Objects.equals(comment_Replaies, commnetPCEntity.comment_Replaies) && Objects.equals(comment_Reactions, commnetPCEntity.comment_Reactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment_Value, userEntity, postComuEntity, comment_Replaies, comment_Reactions);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", comment_Value='" + getComment_Value() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            ", postComuEntity='" + getPostComuEntity() + "'" +
            ", comment_Replaies='" + getComment_Replaies() + "'" +
            ", comment_Reactions='" + getComment_Reactions() + "'" +
            "}";
    }

    
}
