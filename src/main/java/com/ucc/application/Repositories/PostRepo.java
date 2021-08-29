package com.ucc.application.Repositories;

import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.PostEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<PostEntity,Long> {

    @Query("SELECT p FROM PostEntity p WHERE p.title LIKE %:value% OR p.post_Value LIKE %:value% ")
    Optional<List<PostEntity>> search(@Param("value") String value);

    @Query("SELECT p FROM PostEntity p order by p.id ")
    Optional<List<PostEntity>> getAllUserPost();
    
}
