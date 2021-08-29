package com.ucc.application.Repositories;

import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.PostComuEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostComRepo extends CrudRepository<PostComuEntity,Long> {

    @Query("SELECT p FROM PostComuEntity p WHERE p.title LIKE %:value% OR p.post_Value LIKE %:value% ")
    Optional<List<PostComuEntity>> search(@Param("value") String value);

    // @Query("SELECT p FROM PostComuEntity p order by p.id ")
    // Optional<List<PostComuEntity>> getAllUserPost();

    @Query("SELECT p FROM PostComuEntity p WHERE p.communityEntity.id=:community_id ")
    Optional<List<PostComuEntity>> getAllUserPost(@Param("community_id") Long community_id);
    
}
