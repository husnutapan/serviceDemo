package com.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Location;

@Repository
public class LocationDAOImpl implements LocationDAO {
	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public ArrayList<Location> getLocationsWithVehicleId(int vehicleId) {
		//
		// TODO Auto-generated method stub
		return null;
	}
}
