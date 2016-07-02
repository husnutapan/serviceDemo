package com.service;

import com.model.Parent;
import com.model.Tuser;

public interface ParentService {

	public boolean loginUser(Tuser tuser);

	public void createParent(Parent parent);

	public void deleteParent(int parentId);

	public void updateParent(Parent parent);
}
