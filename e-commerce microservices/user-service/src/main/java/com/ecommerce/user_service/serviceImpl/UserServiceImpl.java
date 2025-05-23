package com.ecommerce.user_service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.user_service.payloads.RegisterDto;
import com.ecommerce.user_service.payloads.UserResponseDto;
import com.ecommerce.user_service.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserResponseDto registerUser(RegisterDto userRegisterDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserResponseDto updateUser(Long userId, RegisterDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserResponseDto> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponseDto getUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
