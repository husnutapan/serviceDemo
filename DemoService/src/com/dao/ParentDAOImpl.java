package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Parent;
@Repository
public class ParentDAOImpl implements ParentDAO{
	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void saveParent(Parent parent) {
		entityManager.getTransaction().begin();
		entityManager.persist(parent);
		entityManager.getTransaction().commit();
	}
}
