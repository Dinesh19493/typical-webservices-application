package com.webservices.app.services;

import com.webservices.app.shared.dto.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userDto);
	
}
