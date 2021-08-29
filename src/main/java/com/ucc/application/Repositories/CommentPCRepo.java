package com.ucc.application.Repositories;

import java.util.List;
import java.util.Optional;

import com.ucc.application.Entities.CommnetPCEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentPCRepo extends CrudRepository<CommnetPCEntity,Long> {

    @Query("SELECT c FROM CommnetPCEntity c where c.postComuEntity.id=:val order by c.id")
    Optional<List<CommnetPCEntity>> getcommentposts(@Param("val") Long val);
    
}
