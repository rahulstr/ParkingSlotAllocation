package com.example.psap.service;

import java.util.List;
import java.util.Optional;

import com.example.psap.entity.Admin;
import com.example.psap.entity.ParkingPremise;
import com.example.psap.exception.DuplicateParkingPremiseException;
import com.example.psap.exception.NoSuchParkingPremiseException;

public interface IAdminService {

	public boolean login1(String username,String password);

	public Admin saveParkingPremise(Admin admin);

	List<ParkingPremise> getAllPremise();

	Optional<ParkingPremise> getPremise(Integer parkingPremiseId) throws NoSuchParkingPremiseException;

	Optional<ParkingPremise> getPremiseByName(String parkingPremiseName) throws NoSuchParkingPremiseException;

	public ParkingPremise deleteParkingPremise(Integer id);

	public ParkingPremise updateParkingPremise(Integer parkingPremiseId, ParkingPremise premise);

	public ParkingPremise createParkingPremise(ParkingPremise premise) throws DuplicateParkingPremiseException;
}