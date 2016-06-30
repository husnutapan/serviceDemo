package com.dao;

import com.model.Student;
import com.model.Tuser;

public interface StudentDAO {
	public Student getUIDWithTuser(Tuser tuser);
}
