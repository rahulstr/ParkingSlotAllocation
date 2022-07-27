package com.example.psap.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.psap.dao.UserRepository;
import com.example.psap.entity.Users;
import com.example.psap.exception.DuplicateUserException;
import com.example.psap.exception.UserNotFoundException;



@Service
public class UserServiceimpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users addUser(Users user) throws DuplicateUserException{
		if(userRepository.findByusername(user.getUsername())!=null) {
			throw new DuplicateUserException(null);
		}
		return userRepository.save(user);
		
	}
	
	@Override
	public boolean login(String username, String password) {
		Optional<Users> opt=userRepository.findByUsernameAndPassword(username, password);
		if(!opt.isPresent())
		{
			throw new UserNotFoundException();
		}
		return true;

	}

	@Override
	public Users updateUser(Integer user_id, Users user) throws UserNotFoundException{
		Optional<Users> existingUser = userRepository.findById(user_id);
		if (existingUser.isPresent()) {
			Users user1 = existingUser.get();
			user1.setUsername(user.getUsername());
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setMobile(user.getMobile());

			return userRepository.save(user1);
		} else {
			throw new UserNotFoundException();
		}
		
	}



	

}