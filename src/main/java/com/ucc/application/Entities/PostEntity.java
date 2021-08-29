package com.ucc.application.Entities;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Posts")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class PostEntity {

    /**** Attribute Area ****/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Post_id")
    private Long id;

    @Column(name="Title")
    private String title;

    @Column(name="Post_Value")
    private String post_Value;

    @Column(name="Attachment")
    private String attachment;

    @JsonFormat(pattern = "yyyy-mm-dd@HH:MM:SS")
    @Column(name="Created_At")
    private Date created_At;
    

    
    /**** Relational Attribute ****/

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = true)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "postEntity",cascade = CascadeType.ALL)
    private List<LikeEntity> post_Likes;

    @OneToMany(mappedBy = "postEntity",cascade = CascadeType.ALL)
    private List<LoveEntity> post_Loves;

    @OneToMany(mappedBy = "postEntity",cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "postEntity",cascade = CascadeType.ALL)
    private List<ReplayEntity> replaies;


    public PostEntity() {
    }

    public PostEntity(Long id, String title, String post_Value, String attachment, Date created_At, UserEntity userEntity, List<LikeEntity> post_Likes, List<LoveEntity> post_Loves, List<CommentEntity> comments, List<ReplayEntity> replaies) {
        this.id = id;
        this.title = title;
        this.post_Value = post_Value;
        this.attachment = attachment;
        this.created_At = created_At;
        this.userEntity = userEntity;
        this.post_Likes = post_Likes;
        this.post_Loves = post_Loves;
        this.comments = comments;
        this.replaies = replaies;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost_Value() {
        return this.post_Value;
    }

    public void setPost_Value(String post_Value) {
        this.post_Value = post_Value;
    }

    public String getAttachment() {
        return this.attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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

    public List<LikeEntity> getPost_Likes() {
        return this.post_Likes;
    }

    public void setPost_Likes(List<LikeEntity> post_Likes) {
        this.post_Likes = post_Likes;
    }

    public List<LoveEntity> getPost_Loves() {
        return this.post_Loves;
    }

    public void setPost_Loves(List<LoveEntity> post_Loves) {
        this.post_Loves = post_Loves;
    }

    public List<CommentEntity> getComments() {
        return this.comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<ReplayEntity> getReplaies() {
        return this.replaies;
    }

    public void setReplaies(List<ReplayEntity> replaies) {
        this.replaies = replaies;
    }

    public PostEntity id(Long id) {
        setId(id);
        return this;
    }

    public PostEntity title(String title) {
        setTitle(title);
        return this;
    }

    public PostEntity post_Value(String post_Value) {
        setPost_Value(post_Value);
        return this;
    }

    public PostEntity attachment(String attachment) {
        setAttachment(attachment);
        return this;
    }

    public PostEntity created_At(Date created_At) {
        setCreated_At(created_At);
        return this;
    }

    public PostEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public PostEntity post_Likes(List<LikeEntity> post_Likes) {
        setPost_Likes(post_Likes);
        return this;
    }

    public PostEntity post_Loves(List<LoveEntity> post_Loves) {
        setPost_Loves(post_Loves);
        return this;
    }

    public PostEntity comments(List<CommentEntity> comments) {
        setComments(comments);
        return this;
    }

    public PostEntity replaies(List<ReplayEntity> replaies) {
        setReplaies(replaies);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PostEntity)) {
            return false;
        }
        PostEntity postEntity = (PostEntity) o;
        return Objects.equals(id, postEntity.id) && Objects.equals(title, postEntity.title) && Objects.equals(post_Value, postEntity.post_Value) && Objects.equals(attachment, postEntity.attachment) && Objects.equals(created_At, postEntity.created_At) && Objects.equals(userEntity, postEntity.userEntity) && Objects.equals(post_Likes, postEntity.post_Likes) && Objects.equals(post_Loves, postEntity.post_Loves) && Objects.equals(comments, postEntity.comments) && Objects.equals(replaies, postEntity.replaies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, post_Value, attachment, created_At, userEntity, post_Likes, post_Loves, comments, replaies);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", post_Value='" + getPost_Value() + "'" +
            ", attachment='" + getAttachment() + "'" +
            ", created_At='" + getCreated_At() + "'" +
            ", userEntity='" + getUserEntity() + "'" +
            ", post_Likes='" + getPost_Likes() + "'" +
            ", post_Loves='" + getPost_Loves() + "'" +
            ", comments='" + getComments() + "'" +
            ", replaies='" + getReplaies() + "'" +
            "}";
    }

    
}
