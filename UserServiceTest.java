package com.example.psap.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.psap.dao.UserRepository;
import com.example.psap.entity.Users;
import com.example.psap.exception.DuplicateUserException;
import com.example.psap.exception.UserNotFoundException;

class UserServiceTest {

	@InjectMocks
	UserServiceimpl userServiceimpl;
	
	@Mock
	UserRepository userRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddUser() {
		
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		when(userRepository.save(users)).thenReturn(users);
		Users ur=userServiceimpl.addUser(users);
		
		assertNotNull(ur);
		assertEquals(ur.getMobile(),"9876543210");
		verify(userRepository,times(1)).save(users); 
	}

	
	@Test
	void testAddUserWithException() {
		
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		when(userRepository.save(users)).thenThrow(DuplicateUserException.class);
		assertThrows(DuplicateUserException.class,()-> userServiceimpl.addUser(users));
	}
	
	@Test
	void testLogin() {
		
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		Optional<Users> optional= Optional.of(users);
		
		when(userRepository.findByUsernameAndPassword("Mahee","mahee")).thenReturn(optional);
		userServiceimpl.login("Mahee","mahee");
		
		Users ur=userRepository.findByUsernameAndPassword("Mahee","mahee").get();
		assertNotNull(ur);
		assertEquals(ur.getMobile(),"9876543210");
		 
		
	}
	
	
	@Test
	void testLoginWithException() {
		
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		Optional<Users> optional= Optional.of(users);
		
		when(userRepository.findByUsernameAndPassword("Mahee","mahee")).thenThrow(UserNotFoundException.class);
		assertThrows(UserNotFoundException.class,()->userServiceimpl.login(users.getUsername(),users.getPassword()));
		 
		
	}

	@Test
	void testUpdateUser() {
		Users users =new Users();
		users.setEmail("ma@gmail.com");
		users.setMobile("9876543210");
		users.setPassword("mahee");
		users.setUser_id(1);
		users.setUsername("Mahee");
		
		Optional<Users> optional= Optional.of(users);
		
		when(userRepository.findById(1)).thenReturn(optional);
		when(userRepository.save(users)).thenReturn(users);
		Users ur=userServiceimpl.updateUser(1, users);
		
		assertNotNull(ur);
		assertEquals(ur.getMobile(),"9876543210");
	}

	

}
