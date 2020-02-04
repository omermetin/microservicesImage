package com.omrmtn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.omrmtn.service.SchoolService;

@RestController
public class SchoolController {

	@Autowired
	SchoolService studentService;

	// http://localhost:8015/getSchoolDetails/school1
	// @RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
	@GetMapping(value = "/getSchoolDetails/{schoolname}")
	public String getStudents(@PathVariable String schoolname) {
		System.out.println("Going to call student service to get data!");
		return studentService.callStudentServiceAndGetData(schoolname);
	}

	// http://localhost:8015/test1/school1
	@GetMapping(value = "/test1/{schoolname}")
	public String getStudents1(@PathVariable String schoolname) {
		System.out.println("test1 Going to call student service to get data!");
		return studentService.test1(schoolname);
	}

	// http://localhost:8015/test2/school1
	@GetMapping(value = "/test2/{schoolname}")
	public String getStudents2(@PathVariable String schoolname) {
		System.out.println("test2 Going to call student service to get data!");
		return studentService.test2(schoolname);
	}

//-----------------------------------------------------------------	
	@HystrixCommand(fallbackMethod = "myShowFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	@GetMapping(value = "/")
	public String hello() throws InterruptedException {
		Thread.sleep(3000);
		return "Welcome Hystrix";
	}

	private String myShowFallBack() {
		return "Request fails. It takes long time to response";
	}

}