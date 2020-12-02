package com.webservices.app.services.impls;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.app.io.entity.UserEntity;
import com.webservices.app.repositories.UserRepository;
import com.webservices.app.services.UserService;
import com.webservices.app.shared.dto.UserDTO;
import com.webservices.app.shared.dto.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public UserDTO createUser(UserDTO userDto) {

		if(userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("Record already exist!");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);

		userEntity.setUserId(utils.generateRandomUserId(30));
		userEntity.setEncryptedPassword("testPwd");
		
		UserEntity storedUserEntityObject = userRepository.save(userEntity);
		
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(storedUserEntityObject, returnValue);
		
		return returnValue;
	}

}
