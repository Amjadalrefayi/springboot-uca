package com.ucc.application.Repositories;

import javax.transaction.Transactional;

import com.ucc.application.Entities.ReplayPCEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ReplayPcRepo extends CrudRepository<ReplayPCEntity,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM ReplayPCEntity r WHERE r.id=:id ")
    void deleteReplay(@Param("id")Long id);
    
}
