package com.ucc.application.Repositories;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ucc.application.Entities.CommentEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<CommentEntity,Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CommentEntity c WHERE c.id=:id ")
    void deleteComment(@Param("id")Long id);

    @Query("SELECT c FROM CommentEntity c where c.postEntity.id=:val order by c.id")
    Optional<List<CommentEntity>> getcommentposts(@Param("val") Long val);
    
}
