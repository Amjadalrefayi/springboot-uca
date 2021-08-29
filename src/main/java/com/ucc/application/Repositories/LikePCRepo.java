package com.ucc.application.Repositories;

import javax.transaction.Transactional;

import com.ucc.application.Entities.LikePCEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePCRepo extends CrudRepository<LikePCEntity,Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM LikePCEntity l WHERE l.id=:id ")
    void deleteLike(@Param("id")Long id);
}
