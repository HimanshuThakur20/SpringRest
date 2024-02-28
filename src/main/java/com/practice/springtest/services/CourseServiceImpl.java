package com.practice.springtest.services;

import java.util.ArrayList;

import java.util.List;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.stereotype.Service;

import com.practice.springrest.dao.CourseDao;
import com.practice.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	//List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145,"Java core course","basics of java"));
//		list.add(new Course(1452,"Spring boot course","basics of spring"));		
		
	}
	
	@Override
	public List<Course> getCourses() {			
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
//		return c;
		return courseDao.getOne(courseId);
	}

	@Override
	public Course putCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course updatedCourse) {
//		for(int i = 0; i < list.size(); i++) {
//			Course course = list.get(i);
//			if(course.getId()== updatedCourse.getId()) {
//				course.setTitle(updatedCourse.getTitle());
//				course.setDescription(updatedCourse.getDescription());
//				
//				list.set(i, course);
//				return course;
//			}
//		}
		
		return courseDao.save(updatedCourse);
	}

	@Override
	public String deleteCourse(long courseId) {
//		Iterator <Course> iterator = list.iterator();
//		while(iterator.hasNext()) {
//			Course course = iterator.next();
//			if(course.getId()== courseId) {
//				iterator.remove();
//				return null;
//			}
//		}
//		return "Course not found";
		
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
	
		return "Course is deleted";
	}

}
