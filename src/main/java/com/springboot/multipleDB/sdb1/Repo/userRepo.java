package com.springboot.multipleDB.sdb1.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.multipleDB.sdb1.entities.user;

public interface userRepo extends JpaRepository<user, Integer> {
	

}
