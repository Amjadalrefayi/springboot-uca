package com.ucc.application.Repositories;

import javax.transaction.Transactional;

import com.ucc.application.Entities.ComReactPCEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComReactPCRepo extends CrudRepository<ComReactPCEntity,Long> {
    
    @Transactional
    @Modifying
    @Query("DELETE FROM ComReactPCEntity c WHERE c.id=:id ")
    void deleteComReact(@Param("id")Long id);
}
