package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LocationDAO;
import com.model.Location;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationDAO locationDAO;
	
	
	@Override
	public List<Location> getLocationsWithVehicleId(int vehicleId) {
		return locationDAO.getLocationsWithVehicleId(vehicleId);
	}

}
