package com.arthurgb80.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurgb80.crudspring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
