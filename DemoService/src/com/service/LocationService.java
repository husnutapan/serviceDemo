package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Location;

public interface LocationService {
	public List<Location> getLocationsWithVehicleId(int vehicleId);
}
