package com.sony.springboot.mydiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sony.springboot.mydiary.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select * from user where username=:username LIMIT 1",nativeQuery=true)
	public User findByUsername(String username);

}
