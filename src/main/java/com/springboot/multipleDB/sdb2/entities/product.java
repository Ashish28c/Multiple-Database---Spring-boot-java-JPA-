package com.springboot.multipleDB.sdb2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity
public class product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id; 
	private String nameString;
	private String description;
}
