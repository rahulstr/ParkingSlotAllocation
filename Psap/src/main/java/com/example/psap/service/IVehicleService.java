package com.example.psap.service;

import java.util.List;
import com.example.psap.entity.Vehicle;
import com.example.psap.exception.DuplicateVehicleException;


	public interface IVehicleService {

		//add vehicle
		Vehicle addUsersVehicle(Vehicle vehicle, int user_id) throws DuplicateVehicleException;

		public Vehicle findVehicleByVehicleNumber(String vehicleNumber) ;
		public List<Vehicle> getallvehicles();


		public Vehicle removeVehicleByVehicleNumber(String vehicleNumber);


       public  Vehicle modifyVehicle(Vehicle vehicle);

		Vehicle updateVehicle(Integer vehicleId, Vehicle vehicle);

        Vehicle fetchVehicleByVehicleId(Integer vehicleId);

	}

