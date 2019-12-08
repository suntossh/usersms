package com.suntossh.springboot.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suntossh.springboot.users.Entity.UsersEntity;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Long> {
}
