package com.practice.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.springrest.entities.Course;

public interface CourseDao extends JpaRepository<Course,Long> {

}
