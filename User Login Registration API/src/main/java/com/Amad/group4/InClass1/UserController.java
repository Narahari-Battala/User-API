
package com.Amad.group4.InClass1;

//import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// This method is used for user registration
	@PostMapping(path="/users")
	public void addUser(@Valid @RequestBody ApplicationUser user) {
		
		Optional<ApplicationUser> exists = repository.findById(user.getUserId());
		if (exists.isPresent()) {
			
			throw new UserAlreadyExists("user already exists");
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		repository.save(user);
		
	}
	
	// this method is used to get the user details
	@GetMapping(path="/users")
	public ApplicationUser retrieveUsers(@RequestHeader("Authorization") String authorization){
		
		String userId = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                .build()
                .verify(authorization.replace(SecurityConstants.TOKEN_PREFIX, ""))
                .getSubject();
		
		Optional<ApplicationUser> user =  repository.findById(userId);
		
		if (!user.isPresent()) {
			
			throw new UserNotFoundException("user with id: " + userId + " not found");
		}
		
		return user.get();
	}	
	
	// this method is used to update the user details.
	@PutMapping(path="/users")
	
	public void updateUser(@Valid @RequestBody ApplicationUser user) {
		
		Optional<ApplicationUser> oldUser = repository.findById(user.getUserId()); 
		
        if (!oldUser.isPresent()) {
			
			throw new UserNotFoundException("user with id: " + user.getUserId() + " not found");
		}
		ApplicationUser newUser = oldUser.get();
		newUser.setAddress(user.getAddress());
		newUser.setAge(user.getAge());
		newUser.setName(user.getName());
		newUser.setWeight(user.getWeight());
		newUser.setPassword(user.getPassword());
		
		repository.save(newUser);
		
	}
	
}
