package com.practice.springtest.services;
import com.practice.springrest.entities.Course;
import java.util.List;

public interface CourseService {
	public List<Course> getCourses(); 
	public Course getCourse(long courseId);
	public Course putCourse(Course course);
	public Course updateCourse(Course course);
	public String deleteCourse(long courseId);
}
