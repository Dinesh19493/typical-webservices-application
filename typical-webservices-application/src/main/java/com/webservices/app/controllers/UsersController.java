package com.webservices.app.controllers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webservices.app.services.UserService;
import com.webservices.app.shared.dto.UserDTO;
import com.webservices.app.ui.model.request.UserDetailsRequestModel;
import com.webservices.app.ui.model.response.UserDetailsResponseModel;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		return "Hello There!";
	}
	
	@PostMapping
	public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) {
		
		UserDetailsResponseModel returnValue = new UserDetailsResponseModel();
		UserDTO userDto = new UserDTO();
		
		BeanUtils.copyProperties(userDetailsRequestModel, userDto);
		
		UserDTO createdUser = userService.createUser(userDto);
		
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "";
	}
	
}
