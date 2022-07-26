package com.example.psap.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.psap.entity.ParkingSlots;


@Repository
public interface ParkingSlotsDao extends JpaRepository<ParkingSlots, Integer>{

    Optional<ParkingSlots> findByParkingDateAndParkingTime(String d, String t);
	
	Optional<ParkingSlots> findById(Integer parkingSlotId);


}
