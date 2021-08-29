package com.ucc.application.Repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import com.ucc.application.Entities.UserEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepo extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String Email);
    Optional<UserEntity> findById(Long id);
    Optional<UserEntity> findByUserName(String UserName);

    @Query("SELECT u FROM UserEntity u WHERE u.userName LIKE %:val% ")
    Optional<List<UserEntity>> search(@Param("val") String val);

    @Query("SELECT DISTINCT  u FROM UserEntity u INNER JOIN StoryEntity s ON u.id=s.userEntity.id ")
    Optional<List<UserEntity>> getAllUser();
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity u SET u.password =:pass WHERE u.id =:id ")
    void updatePass(@Param("id")Long id ,@Param("pass") String password);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity u SET u.image =:img WHERE u.id =:id ")
    void updateImage(@Param("id")Long id ,@Param("img") String Image);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity u SET u.cover =:cov WHERE u.id =:id ")
    void updateCover(@Param("id")Long id ,@Param("cov") String cover);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity u SET u.firstName =:first WHERE u.id =:id ")
    void updatefirstName(@Param("id")Long id ,@Param("first") String firstName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity u SET u.userName =:name WHERE u.id =:id ")
    void updateUserName(@Param("id")Long id ,@Param("name") String userName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity u SET u.lastName =:last WHERE u.id =:id ")
    void updatelastName(@Param("id")Long id ,@Param("last") String lastname);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity u SET u.age =:ag WHERE u.id =:id ")
    void updateAge(@Param("id")Long id ,@Param("ag") Integer age);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserEntity u SET u.study_Year =:study_Yea WHERE u.id =:id ")
    void updateStudyYear(@Param("id")Long id ,@Param("study_Yea") Integer study_Year);

   
}
