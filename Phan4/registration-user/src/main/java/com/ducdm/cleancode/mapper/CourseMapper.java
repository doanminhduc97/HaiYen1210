package com.ducdm.cleancode.mapper;

import org.springframework.stereotype.Component;

import com.ducdm.cleancode.dto.CourseResDto;
import com.ducdm.cleancode.entity.Course;

@Component
public class CourseMapper {

	public CourseResDto convertToCourseResponseDto(Course course) {
		CourseResDto responseDto = new CourseResDto();
		responseDto.setId(course.getId());
		responseDto.setName(course.getName());
		responseDto.setLocation(course.getLocation());
		responseDto.setTeacherName(course.getTeacher().getName());
		
		return responseDto;
	}

}
