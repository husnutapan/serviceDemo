package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDAO;
import com.model.Student;
import com.model.Tuser;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public Student getUIDWithTuser(Tuser tuser) {
		return studentDAO.getUIDWithTuser(tuser);
	}

}
