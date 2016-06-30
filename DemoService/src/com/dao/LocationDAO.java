package com.dao;

import java.util.ArrayList;

import com.model.Location;

public interface LocationDAO {
	public ArrayList<Location> getLocationsWithVehicleId(int vehicleId);

}
