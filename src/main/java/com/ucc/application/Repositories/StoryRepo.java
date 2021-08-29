package com.ucc.application.Repositories;

import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.StoryEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepo extends CrudRepository<StoryEntity,Long>  {

    @Query("SELECT p.user_stories FROM UserEntity p ")
    Optional<List<StoryEntity>> getAllUserStory();
    
}
