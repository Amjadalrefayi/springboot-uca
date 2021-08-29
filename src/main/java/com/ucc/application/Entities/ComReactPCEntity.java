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
@Table(name = "comreactPC")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ComReactPCEntity {

    /**** Attribute Area ****/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ComReact_id")
    private Long id;

    /**** Relational Attribute ****/

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = true)
    private CommnetPCEntity commnetPCEntity;

    public ComReactPCEntity() {
    }

    public ComReactPCEntity(Long id, UserEntity userEntity, CommnetPCEntity commnetPCEntity) {
        this.id = id;
        this.userEntity = userEntity;
        this.commnetPCEntity = commnetPCEntity;
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

    public CommnetPCEntity getCommnetPCEntity() {
        return this.commnetPCEntity;
    }

    public void setCommnetPCEntity(CommnetPCEntity commnetPCEntity) {
        this.commnetPCEntity = commnetPCEntity;
    }

    public ComReactPCEntity id(Long id) {
        setId(id);
        return this;
    }

    public ComReactPCEntity userEntity(UserEntity userEntity) {
        setUserEntity(userEntity);
        return this;
    }

    public ComReactPCEntity commnetPCEntity(CommnetPCEntity commnetPCEntity) {
        setCommnetPCEntity(commnetPCEntity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ComReactPCEntity)) {
            return false;
        }
        ComReactPCEntity comReactPCEntity = (ComReactPCEntity) o;
        return Objects.equals(id, comReactPCEntity.id) && Objects.equals(userEntity, comReactPCEntity.userEntity)
                && Objects.equals(commnetPCEntity, comReactPCEntity.commnetPCEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEntity, commnetPCEntity);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", userEntity='" + getUserEntity() + "'" + ", commnetPCEntity='"
                + getCommnetPCEntity() + "'" + "}";
    }

}
