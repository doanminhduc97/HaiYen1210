package com.ducdm.cleancode.factory;

import com.ducdm.cleancode.dto.UserDto;
import com.ducdm.cleancode.entity.User;
import com.ducdm.cleancode.enums.UserType;
import com.ducdm.cleancode.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFactory {

    private final UserMapper userMapper = new UserMapper();

    public User createUser(UserDto userDto) {
        User user = null;
        if (UserType.STUDENT.toString().equals(userDto.getMode())) {
            user = userMapper.convertToStudent(userDto);
        } else if (UserType.TEACHER.toString().equals(userDto.getMode())) {
            user = userMapper.convertToTeacher(userDto);
        }
        return user;
    }

}
