package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ParentDAO;
import com.model.Parent;
import com.model.Tuser;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentDAO parentDAO;



	@Override
	public boolean loginUser(Tuser tuser) {
		return parentDAO.loginUser(tuser);
	}

	@Override
	public void createParent(Parent parent) {
			parentDAO.createParent(parent);
		
	}

	@Override
	public void deleteParent(int parentId) {
		parentDAO.deleteParent(parentId);
		
	}

	@Override
	public void updateParent(Parent parent) {
		parentDAO.updateParent(parent);
	}

}
