package com.Sync.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sync.demo.model.SyncEntity;
@Repository
public interface SyncRepository extends JpaRepository<SyncEntity, Integer>{

}
