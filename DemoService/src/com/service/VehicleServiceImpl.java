package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VehicleDAO;
import com.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	private VehicleDAO vehicleDAO;
	
	@Override
	public void saveVehicle(Vehicle vehicle) {
		vehicleDAO.saveVehicle(vehicle);
	}

}
