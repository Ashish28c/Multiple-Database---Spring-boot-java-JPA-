package com.springboot.multipleDB.sdb2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.multipleDB.sdb2.entities.product;

public interface productRepo extends JpaRepository<product, Integer>{

		
	
}
