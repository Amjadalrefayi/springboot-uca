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
@Table(name = "Users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserEntity {

    /**** Attribute Area ****/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_id")
    private Long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "UserName")
    private String userName = firstName + " " + lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "University")
    private String university;

    @Column(name = "Specialize")
    private String specialize;

    @Column(name = "Study_Year")
    private Integer study_Year;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Online")
    private boolean online;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "Created_At")
    private Date created_At;

    @Column(name = "Image")
    private String image;

    @Column(name = "Cover")
    private String cover;

    /**** Relational Attribute ****/

    @ManyToOne
    @JoinColumn(name = "community_id", nullable = true)
    private CommunityEntity communityEntity;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PostEntity> user_Posts;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PostComuEntity> user_PostCom;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LikeEntity> user_Likes;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LoveEntity> user_Loves;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CommnetPCEntity> user_CommentsPC;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CommentEntity> user_Comments;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ReplayEntity> user_Replayies;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ReplayPCEntity> user_ReplayiesPC;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<StoryEntity> user_stories;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ComReactEntity> user_ComReacts;
    
    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ComReactPCEntity> user_ComReactsPC;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<LikePCEntity> user_LikesPC;

    public UserEntity() {
    }

    public UserEntity(Long id, String firstName, String lastName, String userName, String email, String password, String university, String specialize, Integer study_Year, Integer age, boolean online, Date created_At, String image, String cover, CommunityEntity communityEntity, List<PostEntity> user_Posts, List<PostComuEntity> user_PostCom, List<LikeEntity> user_Likes, List<LoveEntity> user_Loves, List<CommnetPCEntity> user_CommentsPC, List<CommentEntity> user_Comments, List<ReplayEntity> user_Replayies, List<ReplayPCEntity> user_ReplayiesPC, List<StoryEntity> user_stories, List<ComReactEntity> user_ComReacts, List<ComReactPCEntity> user_ComReactsPC, List<LikePCEntity> user_LikesPC) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.university = university;
        this.specialize = specialize;
        this.study_Year = study_Year;
        this.age = age;
        this.online = online;
        this.created_At = created_At;
        this.image = image;
        this.cover = cover;
        this.communityEntity = communityEntity;
        this.user_Posts = user_Posts;
        this.user_PostCom = user_PostCom;
        this.user_Likes = user_Likes;
        this.user_Loves = user_Loves;
        this.user_CommentsPC = user_CommentsPC;
        this.user_Comments = user_Comments;
        this.user_Replayies = user_Replayies;
        this.user_ReplayiesPC = user_ReplayiesPC;
        this.user_stories = user_stories;
        this.user_ComReacts = user_ComReacts;
        this.user_ComReactsPC = user_ComReactsPC;
        this.user_LikesPC = user_LikesPC;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniversity() {
        return this.university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpecialize() {
        return this.specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public Integer getStudy_Year() {
        return this.study_Year;
    }

    public void setStudy_Year(Integer study_Year) {
        this.study_Year = study_Year;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isOnline() {
        return this.online;
    }

    public boolean getOnline() {
        return this.online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Date getCreated_At() {
        return this.created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public CommunityEntity getCommunityEntity() {
        return this.communityEntity;
    }

    public void setCommunityEntity(CommunityEntity communityEntity) {
        this.communityEntity = communityEntity;
    }

    public List<PostEntity> getUser_Posts() {
        return this.user_Posts;
    }

    public void setUser_Posts(List<PostEntity> user_Posts) {
        this.user_Posts = user_Posts;
    }

    public List<PostComuEntity> getUser_PostCom() {
        return this.user_PostCom;
    }

    public void setUser_PostCom(List<PostComuEntity> user_PostCom) {
        this.user_PostCom = user_PostCom;
    }

    public List<LikeEntity> getUser_Likes() {
        return this.user_Likes;
    }

    public void setUser_Likes(List<LikeEntity> user_Likes) {
        this.user_Likes = user_Likes;
    }

    public List<LoveEntity> getUser_Loves() {
        return this.user_Loves;
    }

    public void setUser_Loves(List<LoveEntity> user_Loves) {
        this.user_Loves = user_Loves;
    }

    public List<CommnetPCEntity> getUser_CommentsPC() {
        return this.user_CommentsPC;
    }

    public void setUser_CommentsPC(List<CommnetPCEntity> user_CommentsPC) {
        this.user_CommentsPC = user_CommentsPC;
    }

    public List<CommentEntity> getUser_Comments() {
        return this.user_Comments;
    }

    public void setUser_Comments(List<CommentEntity> user_Comments) {
        this.user_Comments = user_Comments;
    }

    public List<ReplayEntity> getUser_Replayies() {
        return this.user_Replayies;
    }

    public void setUser_Replayies(List<ReplayEntity> user_Replayies) {
        this.user_Replayies = user_Replayies;
    }

    public List<ReplayPCEntity> getUser_ReplayiesPC() {
        return this.user_ReplayiesPC;
    }

    public void setUser_ReplayiesPC(List<ReplayPCEntity> user_ReplayiesPC) {
        this.user_ReplayiesPC = user_ReplayiesPC;
    }

    public List<StoryEntity> getUser_stories() {
        return this.user_stories;
    }

    public void setUser_stories(List<StoryEntity> user_stories) {
        this.user_stories = user_stories;
    }

    public List<ComReactEntity> getUser_ComReacts() {
        return this.user_ComReacts;
    }

    public void setUser_ComReacts(List<ComReactEntity> user_ComReacts) {
        this.user_ComReacts = user_ComReacts;
    }

    public List<ComReactPCEntity> getUser_ComReactsPC() {
        return this.user_ComReactsPC;
    }

    public void setUser_ComReactsPC(List<ComReactPCEntity> user_ComReactsPC) {
        this.user_ComReactsPC = user_ComReactsPC;
    }

    public List<LikePCEntity> getUser_LikesPC() {
        return this.user_LikesPC;
    }

    public void setUser_LikesPC(List<LikePCEntity> user_LikesPC) {
        this.user_LikesPC = user_LikesPC;
    }

    public UserEntity id(Long id) {
        setId(id);
        return this;
    }

    public UserEntity firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UserEntity lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UserEntity userName(String userName) {
        setUserName(userName);
        return this;
    }

    public UserEntity email(String email) {
        setEmail(email);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
        return this;
    }

    public UserEntity university(String university) {
        setUniversity(university);
        return this;
    }

    public UserEntity specialize(String specialize) {
        setSpecialize(specialize);
        return this;
    }

    public UserEntity study_Year(Integer study_Year) {
        setStudy_Year(study_Year);
        return this;
    }

    public UserEntity age(Integer age) {
        setAge(age);
        return this;
    }

    public UserEntity online(boolean online) {
        setOnline(online);
        return this;
    }

    public UserEntity created_At(Date created_At) {
        setCreated_At(created_At);
        return this;
    }

    public UserEntity image(String image) {
        setImage(image);
        return this;
    }

    public UserEntity cover(String cover) {
        setCover(cover);
        return this;
    }

    public UserEntity communityEntity(CommunityEntity communityEntity) {
        setCommunityEntity(communityEntity);
        return this;
    }

    public UserEntity user_Posts(List<PostEntity> user_Posts) {
        setUser_Posts(user_Posts);
        return this;
    }

    public UserEntity user_PostCom(List<PostComuEntity> user_PostCom) {
        setUser_PostCom(user_PostCom);
        return this;
    }

    public UserEntity user_Likes(List<LikeEntity> user_Likes) {
        setUser_Likes(user_Likes);
        return this;
    }

    public UserEntity user_Loves(List<LoveEntity> user_Loves) {
        setUser_Loves(user_Loves);
        return this;
    }

    public UserEntity user_CommentsPC(List<CommnetPCEntity> user_CommentsPC) {
        setUser_CommentsPC(user_CommentsPC);
        return this;
    }

    public UserEntity user_Comments(List<CommentEntity> user_Comments) {
        setUser_Comments(user_Comments);
        return this;
    }

    public UserEntity user_Replayies(List<ReplayEntity> user_Replayies) {
        setUser_Replayies(user_Replayies);
        return this;
    }

    public UserEntity user_ReplayiesPC(List<ReplayPCEntity> user_ReplayiesPC) {
        setUser_ReplayiesPC(user_ReplayiesPC);
        return this;
    }

    public UserEntity user_stories(List<StoryEntity> user_stories) {
        setUser_stories(user_stories);
        return this;
    }

    public UserEntity user_ComReacts(List<ComReactEntity> user_ComReacts) {
        setUser_ComReacts(user_ComReacts);
        return this;
    }

    public UserEntity user_ComReactsPC(List<ComReactPCEntity> user_ComReactsPC) {
        setUser_ComReactsPC(user_ComReactsPC);
        return this;
    }

    public UserEntity user_LikesPC(List<LikePCEntity> user_LikesPC) {
        setUser_LikesPC(user_LikesPC);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) && Objects.equals(firstName, userEntity.firstName) && Objects.equals(lastName, userEntity.lastName) && Objects.equals(userName, userEntity.userName) && Objects.equals(email, userEntity.email) && Objects.equals(password, userEntity.password) && Objects.equals(university, userEntity.university) && Objects.equals(specialize, userEntity.specialize) && Objects.equals(study_Year, userEntity.study_Year) && Objects.equals(age, userEntity.age) && online == userEntity.online && Objects.equals(created_At, userEntity.created_At) && Objects.equals(image, userEntity.image) && Objects.equals(cover, userEntity.cover) && Objects.equals(communityEntity, userEntity.communityEntity) && Objects.equals(user_Posts, userEntity.user_Posts) && Objects.equals(user_PostCom, userEntity.user_PostCom) && Objects.equals(user_Likes, userEntity.user_Likes) && Objects.equals(user_Loves, userEntity.user_Loves) && Objects.equals(user_CommentsPC, userEntity.user_CommentsPC) && Objects.equals(user_Comments, userEntity.user_Comments) && Objects.equals(user_Replayies, userEntity.user_Replayies) && Objects.equals(user_ReplayiesPC, userEntity.user_ReplayiesPC) && Objects.equals(user_stories, userEntity.user_stories) && Objects.equals(user_ComReacts, userEntity.user_ComReacts) && Objects.equals(user_ComReactsPC, userEntity.user_ComReactsPC) && Objects.equals(user_LikesPC, userEntity.user_LikesPC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, email, password, university, specialize, study_Year, age, online, created_At, image, cover, communityEntity, user_Posts, user_PostCom, user_Likes, user_Loves, user_CommentsPC, user_Comments, user_Replayies, user_ReplayiesPC, user_stories, user_ComReacts, user_ComReactsPC, user_LikesPC);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", userName='" + getUserName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", university='" + getUniversity() + "'" +
            ", specialize='" + getSpecialize() + "'" +
            ", study_Year='" + getStudy_Year() + "'" +
            ", age='" + getAge() + "'" +
            ", online='" + isOnline() + "'" +
            ", created_At='" + getCreated_At() + "'" +
            ", image='" + getImage() + "'" +
            ", cover='" + getCover() + "'" +
            ", communityEntity='" + getCommunityEntity() + "'" +
            ", user_Posts='" + getUser_Posts() + "'" +
            ", user_PostCom='" + getUser_PostCom() + "'" +
            ", user_Likes='" + getUser_Likes() + "'" +
            ", user_Loves='" + getUser_Loves() + "'" +
            ", user_CommentsPC='" + getUser_CommentsPC() + "'" +
            ", user_Comments='" + getUser_Comments() + "'" +
            ", user_Replayies='" + getUser_Replayies() + "'" +
            ", user_ReplayiesPC='" + getUser_ReplayiesPC() + "'" +
            ", user_stories='" + getUser_stories() + "'" +
            ", user_ComReacts='" + getUser_ComReacts() + "'" +
            ", user_ComReactsPC='" + getUser_ComReactsPC() + "'" +
            ", user_LikesPC='" + getUser_LikesPC() + "'" +
            "}";
    }


}
