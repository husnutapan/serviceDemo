package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocationsWithVehicleId(int vehicleId) {
		Query query = entityManager.createNativeQuery("SELECT l FROM vehicle_location vl INNER JOIN "
				+ "location l ON vl.location_id = l.id AND vl.vehicle_id=?").setParameter(1, vehicleId);
		return (List<Location>) query.getResultList();
	}
}