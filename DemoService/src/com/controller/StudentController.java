package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
}
