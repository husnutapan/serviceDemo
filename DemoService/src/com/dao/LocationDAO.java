package com.dao;

import java.util.List;

import com.model.Location;

public interface LocationDAO {
	public List<Location> getLocationsWithVehicleId(int vehicleId);

}
