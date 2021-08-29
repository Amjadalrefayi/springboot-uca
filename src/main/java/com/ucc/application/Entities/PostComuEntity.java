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
@Table(name = "postCommunity")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class PostComuEntity {

    /**** Attribute Area ****/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PostCom_id")
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

    @ManyToOne
    @JoinColumn(name = "com_id" , nullable = true)
    private CommunityEntity communityEntity;

    @OneToMany(mappedBy = "postComuEntity",cascade = CascadeType.ALL)
    private List<LikePCEntity> post_Likes;

    @OneToMany(mappedBy = "postComuEntity",cascade = CascadeType.ALL)
    private List<CommnetPCEntity> comments;

    @OneToMany(mappedBy = "postComuEntity",cascade = CascadeType.ALL)
    private List<ReplayPCEntity> replaies;



    public PostComuEntity() {
    }

    public PostComuEntity(Long id, String title, String post_Value, String attachment, Date created_At, UserEntity userEntity, CommunityEntity communityEntity, List<LikePCEntity> post_Likes, List<CommnetPCEntity> comments, List<ReplayPCEntity> replaies) {
        this.id = id;
        this.title = title;
        this.post_Value = post_Value;
        this.attachment = attachment;
        this.created_At = created_At;
        this.userEntity = userEntity;
        this.communityEntity = communityEntity;
        this.post_Likes = post_Likes;
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

    public CommunityEntity getCommunityEntity() {
        return this.communityEntity;
    }

    public void setCommunityEntity(CommunityEntity communityEntity) {
        this.communityEntity = communityEntity;
    }

    public List<LikePCEntity> getPost_Likes() {
        return this.post_Likes;
    }

    public void setPost_Likes(List<LikePCEntity> post_Likes) {
        this.post_Likes = post_Likes;
    }

    public List<CommnetPCEntity> getComments() {
        return this.comments;
    }

    public void setComments(List<CommnetPCEntity> comments) {
        this.comments = comments;
    }

    public List<ReplayPCEntity> getReplaies() {
        return this.replaies;
    }

    public void setReplaies(List<ReplayPCEntity> replaies) {
        this.replaies = replaies;
    }

    public PostComuEntity id(Long id) {
        setId(id);
        return this;
    }

    public PostComuEntity title(String title) {
        setTitle(title);
        return this;
    }

    public PostComuEntity post_Value(String post_Value) {
        setPost_Value(post_Value);
        return this;
    }

    public PostComuEntity attachment(String attachment) {
        setAttachment(attachment);
        return this;
    }

    public PostComuEntity created_At(Date created_At) {
        setCreated_At(created_At);
        return this;
    }

    public PostComuEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public PostComuEntity communityEntity(CommunityEntity communityEntity) {
        setCommunityEntity(communityEntity);
        return this;
    }

    public PostComuEntity post_Likes(List<LikePCEntity> post_Likes) {
        setPost_Likes(post_Likes);
        return this;
    }

    public PostComuEntity comments(List<CommnetPCEntity> comments) {
        setComments(comments);
        return this;
    }

    public PostComuEntity replaies(List<ReplayPCEntity> replaies) {
        setReplaies(replaies);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PostComuEntity)) {
            return false;
        }
        PostComuEntity postComuEntity = (PostComuEntity) o;
        return Objects.equals(id, postComuEntity.id) && Objects.equals(title, postComuEntity.title) && Objects.equals(post_Value, postComuEntity.post_Value) && Objects.equals(attachment, postComuEntity.attachment) && Objects.equals(created_At, postComuEntity.created_At) && Objects.equals(userEntity, postComuEntity.userEntity) && Objects.equals(communityEntity, postComuEntity.communityEntity) && Objects.equals(post_Likes, postComuEntity.post_Likes) && Objects.equals(comments, postComuEntity.comments) && Objects.equals(replaies, postComuEntity.replaies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, post_Value, attachment, created_At, userEntity, communityEntity, post_Likes, comments, replaies);
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
            ", communityEntity='" + getCommunityEntity() + "'" +
            ", post_Likes='" + getPost_Likes() + "'" +
            ", comments='" + getComments() + "'" +
            ", replaies='" + getReplaies() + "'" +
            "}";
    }



}
