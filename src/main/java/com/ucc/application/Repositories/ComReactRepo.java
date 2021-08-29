package com.ucc.application.Repositories;

import javax.transaction.Transactional;

import com.ucc.application.Entities.ComReactEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComReactRepo extends CrudRepository<ComReactEntity,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM ComReactEntity c WHERE c.id=:id ")
    void deleteComReact(@Param("id")Long id);
    
}
