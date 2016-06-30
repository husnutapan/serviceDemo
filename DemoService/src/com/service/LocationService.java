package com.service;

import java.util.ArrayList;

import com.model.Location;

public interface LocationService {
	public ArrayList<Location> getLocationsWithVehicleId(int vehicleId);
}
