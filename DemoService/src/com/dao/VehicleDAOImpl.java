package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Vehicle;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void saveVehicle(Vehicle vehicle) {
		entityManager.getTransaction().begin();
		entityManager.persist(vehicle);
		entityManager.getTransaction().commit();
	}
}
