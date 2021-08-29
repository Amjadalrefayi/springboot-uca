package com.ucc.application.Repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ucc.application.Entities.ReplayEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ReplayRepo extends CrudRepository<ReplayEntity,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM ReplayEntity r WHERE r.id=:id ")
    void deleteReplay(@Param("id")Long id);
    
    @Query("SELECT r FROM ReplayEntity r where r.commentEntity.id=:val order by r.id")
    Optional<List<ReplayEntity>> getreplayposts(@Param("val") Long val);
}
