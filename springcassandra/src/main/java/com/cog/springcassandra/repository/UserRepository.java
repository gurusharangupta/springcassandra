package com.cog.springcassandra.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.cog.springcassandra.data.User;

public interface UserRepository extends CrudRepository<User,UUID>{

}
