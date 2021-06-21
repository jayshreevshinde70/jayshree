package com.springrest.springrest.controller;



import java.util.List;

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

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CoursesService;

@RestController
public class Mycontroller {
	
	@Autowired
	private CoursesService coursesService;

	@GetMapping("/home")
	public String home()
	{
		return "Welcome";
	}
	
	//get the courses
	
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		
		return this.coursesService.getCourses();
	}
	
	//get Single courses
	@GetMapping("/course/{courseId}")
	public Course getCourses(@PathVariable String courseId )
	{
		
		return this.coursesService.getcourse(Long.parseLong(courseId));
	}
	
	// add the courses
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course course)
	{
		
		return this.coursesService.addcourse(course);
	}
	
	//update the course
	@PutMapping("/courses")
	public Course updatecourse(@RequestBody Course course)
	{
		
		return this.coursesService.addcourse(course);
	}
	
	//delete the course
	@DeleteMapping(("/course/{courseId}"))
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId )
	{
		try {
			
		this.coursesService.deletecourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
