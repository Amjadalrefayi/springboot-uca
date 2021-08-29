package com.ucc.application.Repositories;

import java.util.Optional;



import com.ucc.application.Entities.CommunityEntity;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepo extends CrudRepository<CommunityEntity,Long> {

   
    Optional<CommunityEntity> findByName (String name);
    
    
}
