package com.practice.springrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springrest.entities.Course;
import com.practice.springtest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to courses application";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	@GetMapping("courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course postCourse(@RequestBody Course course) {
		return this.courseService.putCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
//	@DeleteMapping("courses/{courseId}")
//	public ResponseEntity<Map<String, String>> deleteCourse(@PathVariable String courseId){
//		try {
//			String result = this.courseService.deleteCourse(Long.parseLong(courseId));
//			if(result !=null) {
//				throw new Exception();
//			}
//		    Map<String, String> response = new HashMap<>();
//	        response.put("message", "The course has been deleted");
//			return  ResponseEntity.ok(response);
//		}catch(Exception e) {
//			Map<String, String> errorResponse = new HashMap<>();
//			errorResponse.put("error", "Cannot delete the course");
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//		}
//	}
	// Delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
	    try {
	        this.courseService.deleteCourse(Long.parseLong(courseId));
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
}
