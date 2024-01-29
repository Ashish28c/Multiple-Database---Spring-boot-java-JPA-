package com.springboot.multipleDB;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.multipleDB.sdb1.Repo.userRepo;
import com.springboot.multipleDB.sdb1.entities.user;
import com.springboot.multipleDB.sdb2.Repo.productRepo;
import com.springboot.multipleDB.sdb2.entities.product;

@RestController
public class Controller {
	
	@Autowired
	private userRepo userRepo;
	
	@Autowired
	private productRepo productRepo;
	

	
	@GetMapping("/user")
	public List<user> getuser() {
		
		return this.userRepo.findAll();
		
	}
	
	@GetMapping("/product")
	public List<product> getproducts() {
		
		return this.productRepo.findAll();
		
	}
	
	@PostMapping("/user")
	public user addUser(@RequestBody user newUser) {
	    user savedUser = this.userRepo.save(newUser);
	    return savedUser;
	} 

	@PostMapping("/product")
	public product addProduct(@RequestBody product newProduct) {
	    product savedProduct = this.productRepo.save(newProduct);
	    return savedProduct;
	} 

	
	@DeleteMapping("/user/{userId}")
	public user Deleteuser(@PathVariable("userId") Integer userId) {
		
		 userRepo.deleteById(userId);
		return null;	
		
	}
	
	@DeleteMapping("/product/{productId}")
	public product Deleteproduct(@PathVariable("productId") Integer productId) {
		
		 productRepo.deleteById(productId);
		return null;	
		
	}
		
	@PutMapping("/user/{userId}")
	public user updateUser(@RequestBody user updatedUser, @PathVariable("userId") int userId) {
	    user existingUser = this.userRepo.findById(userId).orElse(null);
	    if (existingUser != null) {
	 
	    	
	        existingUser.setUsename(updatedUser.getUsename());
	       
	      
	        this.userRepo.save(existingUser);
	    }
	    return existingUser;
	}

	@PutMapping("/product/{productId}")
	public product updateProduct(@RequestBody product updatedProduct, @PathVariable("productId") int productId) {
	    product existingProduct = this.productRepo.findById(productId).orElse(null);
	    if (existingProduct != null) {
	      
	        existingProduct.setNameString(updatedProduct.getNameString());
	        existingProduct.setDescription(updatedProduct.getDescription());
	    
	        
	        this.productRepo.save(existingProduct);
	    }
	    return existingProduct;
	}


}
