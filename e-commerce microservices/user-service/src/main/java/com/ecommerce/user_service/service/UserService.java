package com.ecommerce.user_service.service;

import java.util.List;

import com.ecommerce.user_service.entity.User;
import com.ecommerce.user_service.payloads.RegisterDto;
import com.ecommerce.user_service.payloads.UserResponseDto;

public interface UserService {
	UserResponseDto registerUser(RegisterDto userRegisterDto);
	void deleteUser(Long userId);
	UserResponseDto updateUser(Long userId,RegisterDto user);
	List<UserResponseDto> getUsers();
	UserResponseDto getUser(Long userId);
	
}
