package com.example.psap.service;

import java.util.List;
import java.util.Optional;

import com.example.psap.dao.PremiseRepository;
import com.example.psap.exception.DuplicateParkingPremiseException;
import com.example.psap.exception.NoSuchParkingPremiseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.psap.dao.AdminRepository;
import com.example.psap.entity.Admin;
import com.example.psap.entity.ParkingPremise;




@Service
public class AdminServiceImplement implements IAdminService{
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private PremiseRepository premiseRepository;

	@Override
	public boolean login1(String username, String password) {
		Optional<Admin> opt=adminRepo.findByUsernameAndPassword(username, password);
		if(opt.isPresent())
		{
			return true;
		}
		return false;

	}

	@Override
	public Admin saveParkingPremise(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}

	@Override
	public List<ParkingPremise> getAllPremise() {
		// TODO Auto-generated method stub
		return premiseRepository.findAll();
	}



	@Override
	public Optional<ParkingPremise> getPremise(Integer parkingPremiseId) throws NoSuchParkingPremiseException {
		// TODO Auto-generated method stub
		Optional<ParkingPremise> premise1 = premiseRepository.findById(parkingPremiseId);
		if(premise1.isPresent()){
			return Optional.of(premise1.get());
		}else{
			throw new NoSuchParkingPremiseException("No Premise Found");
		}
	}

	@Override
	public Optional<ParkingPremise> getPremiseByName(String parkingPremiseName) throws NoSuchParkingPremiseException {
		// TODO Auto-generated method stub
		Optional<ParkingPremise> premise2 = premiseRepository.findByparkingPremiseName(parkingPremiseName);
		if(premise2.isPresent()){
			return Optional.of(premise2.get());
		}else{
			throw new NoSuchParkingPremiseException("No Premise Found");
		}
	}

	@Override
	public ParkingPremise deleteParkingPremise(Integer parkingPremiseId) {
		// TODO Auto-generated method stub
		premiseRepository.deleteById(parkingPremiseId);
		return null;
	}

	@Override
	public ParkingPremise updateParkingPremise(Integer parkingPremiseId, ParkingPremise premise) {
		// TODO Auto-generated method stub
		Optional<ParkingPremise> existingPremise=premiseRepository.findById(parkingPremiseId);
		if(existingPremise.isPresent()){

			ParkingPremise premise1 = existingPremise.get();
			premise1.setParkingPremiseName(premise.getParkingPremiseName());
			premise1.setAddressId(premise.getAddressId());
			premise1.setNumberOfParkingFloors(premise.getNumberOfParkingFloors());
			return premiseRepository.save(premise);
		} else {
			return premiseRepository.save(premise);
		}
	}

	@Override
	public ParkingPremise createParkingPremise(ParkingPremise premise) throws DuplicateParkingPremiseException {
		Optional<ParkingPremise> premise3 = premiseRepository.findByparkingPremiseName(premise.getParkingPremiseName());
		if(premise3.isPresent()){
			throw new DuplicateParkingPremiseException("Premise Already Exist");
		}else{
			return premiseRepository.save(premise);
		}
	}
}

