package com.webservices.app.services.impls;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.webservices.app.io.entity.UserEntity;
import com.webservices.app.io.entity.UserRepository;
import com.webservices.app.services.UserService;
import com.webservices.app.shared.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	@Override
	public UserDTO createUser(UserDTO userDto) {
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(userDto, userEntity);

		userEntity.setUserId("testUser");;
		userEntity.setEncryptedPassword("testPwd");
		
		UserEntity storedUserEntityObject = userRepository.save(userEntity);
		
		UserDTO returnValue = new UserDTO();
		BeanUtils.copyProperties(storedUserEntityObject, returnValue);
		
		return returnValue;
	}

}
