package com.ducdm.cleancode.service;

import com.ducdm.cleancode.factory.UserFactory;
import com.ducdm.cleancode.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducdm.cleancode.dto.UserDto;
import com.ducdm.cleancode.dto.UserResponseDto;
import com.ducdm.cleancode.entity.User;
import com.ducdm.cleancode.error.ErrorCodes;
import com.ducdm.cleancode.error.ServiceRuntimeException;
import com.ducdm.cleancode.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserFactory userFactory;
	private final UserMapper userMapper;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}

	@Transactional()
	public UserResponseDto createUser(UserDto userDto) throws RuntimeException {
		if (findByEmail(userDto.getEmail()) == null) {
			User user = userFactory.createUser(userDto);
			User createdUser = userRepository.save(user);
			UserResponseDto userResponse = userMapper.convertToUserResponseDto(createdUser);
			return userResponse;
		} else {
			throw new ServiceRuntimeException(HttpStatus.BAD_REQUEST, ErrorCodes.USER_E001,
					"Email has already been taken");
		}
	}

}
