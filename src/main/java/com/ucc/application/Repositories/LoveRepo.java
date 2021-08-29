package com.ucc.application.Repositories;

import javax.transaction.Transactional;

import com.ucc.application.Entities.LoveEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoveRepo extends CrudRepository<LoveEntity,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM LoveEntity l WHERE l.id=:id ")
    void deleteLove(@Param("id")Long id);
    
}
