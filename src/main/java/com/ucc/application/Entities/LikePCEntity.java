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
@Table(name="Likespc")
@JsonIdentityInfo(generator =  ObjectIdGenerators.PropertyGenerator.class,property ="id" )
public class LikePCEntity {

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
    @JoinColumn(name="PostCom_id" , nullable= true)
    private PostComuEntity postComuEntity;



    public LikePCEntity() {
    }

    public LikePCEntity(Long id, UserEntity userEntity, PostComuEntity postComuEntity) {
        this.id = id;
        this.userEntity = userEntity;
        this.postComuEntity = postComuEntity;
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

    public PostComuEntity getPostComuEntity() {
        return this.postComuEntity;
    }

    public void setPostComuEntity(PostComuEntity postComuEntity) {
        this.postComuEntity = postComuEntity;
    }

    public LikePCEntity id(Long id) {
        setId(id);
        return this;
    }

    public LikePCEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public LikePCEntity postComuEntity(PostComuEntity postComuEntity) {
        setPostComuEntity(postComuEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LikePCEntity)) {
            return false;
        }
        LikePCEntity likePCEntity = (LikePCEntity) o;
        return Objects.equals(id, likePCEntity.id) && Objects.equals(userEntity, likePCEntity.userEntity) && Objects.equals(postComuEntity, likePCEntity.postComuEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEntity, postComuEntity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            ", postComuEntity='" + getPostComuEntity() + "'" +
            "}";
    }



    
}
