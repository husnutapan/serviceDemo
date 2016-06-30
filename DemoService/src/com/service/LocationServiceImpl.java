package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LocationDAO;
import com.model.Location;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationDAO locationDAO;
	
	
	@Override
	public ArrayList<Location> getLocationsWithVehicleId(int vehicleId) {
		return null;
	}

}
