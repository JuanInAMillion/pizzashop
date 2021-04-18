package com.revature.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.User;
import com.revature.repo.UserRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/userpage")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/user/{userEmail}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "userEmail") String userEmail)
	throws UserNotFoundException{
		User user = userRepo.findById(userEmail) 
		.orElseThrow(() -> new UserNotFoundException("User with email " + userEmail + " was not found"));
	
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/user/{userEmail}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "userEmail") String userEmail, @Valid @RequestBody User userInfo)
	throws UserNotFoundException {
		User user = userRepo.findById(userEmail) 
		.orElseThrow(() -> new UserNotFoundException("User with email " + userEmail + " was not found"));
		
		user.setCcNumber(userInfo.getCcNumber());
		user.setFirstName(userInfo.getFirstName());
		user.setLastName(userInfo.getLastName());
		user.setPassword(userInfo.getPassword());
		user.setPhoneNumber(userInfo.getPhoneNumber());
		user.setUserAddress(userInfo.getUserAddress());
		user.setUserEmail(userInfo.getUserEmail());
		
		final User finalUser = userRepo.save(user);
		return ResponseEntity.ok(finalUser);
	}
	
	@DeleteMapping("user/{userEmail}")
	public void deleteUser(@PathVariable(value = "userEmail") String userEmail) throws UserNotFoundException{
		User user = userRepo.findById(userEmail) 
				.orElseThrow(() -> new UserNotFoundException("User with email " + userEmail + " was not found"));
		
		userRepo.delete(user);
	}
	
}
