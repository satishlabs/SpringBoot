package com.coursecube.springboot.repository.user;

import org.springframework.data.repository.CrudRepository;

import com.coursecube.springboot.entity.user.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
