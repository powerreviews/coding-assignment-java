package com.powerreviews.project.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
    @Query("SELECT MAX(id) FROM restaurant")
    int maxId();
}
