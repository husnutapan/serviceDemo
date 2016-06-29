package com.dao;

import com.model.Parent;
import com.model.Tuser;

public interface ParentDAO {
	public void saveParent(Parent parent);
	public boolean loginUser(Tuser tuser);
}
