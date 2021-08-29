package com.ucc.application.Entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "stories")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class StoryEntity {

     /**** Attribute Area ****/

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "story_id")
     private Long id;

     @Column(name = "text" , nullable = true)
     private String text;

     @Column(name = "image" , nullable =  true)
     private String image;


     @JsonFormat(pattern = "yyyy-mm-dd@HH:MM:SS")
     @Column(name="Created_At")
     private Date created_At;



     /**** Relational Attribute ****/


     @ManyToOne
     @JoinColumn(name = "user_id" , nullable = true)
     private UserEntity userEntity;



    public StoryEntity() {
    }

    public StoryEntity(Long id, String text, String image, Date created_At, UserEntity userEntity) {
        this.id = id;
        this.text = text;
        this.image = image;
        this.created_At = created_At;
        this.userEntity = userEntity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreated_At() {
        return this.created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public StoryEntity id(Long id) {
        setId(id);
        return this;
    }

    public StoryEntity text(String text) {
        setText(text);
        return this;
    }

    public StoryEntity image(String image) {
        setImage(image);
        return this;
    }

    public StoryEntity created_At(Date created_At) {
        setCreated_At(created_At);
        return this;
    }

    public StoryEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StoryEntity)) {
            return false;
        }
        StoryEntity storyEntity = (StoryEntity) o;
        return Objects.equals(id, storyEntity.id) && Objects.equals(text, storyEntity.text) && Objects.equals(image, storyEntity.image) && Objects.equals(created_At, storyEntity.created_At) && Objects.equals(userEntity, storyEntity.userEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, image, created_At, userEntity);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", text='" + getText() + "'" +
            ", image='" + getImage() + "'" +
            ", created_At='" + getCreated_At() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            "}";
    }



     
    
}
