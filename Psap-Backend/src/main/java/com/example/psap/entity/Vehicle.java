package com.example.psap.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
//@Data

//	@NoArgsConstructor
//@ToString(exclude = "ParkingSlots")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "vehicle_id")
    private int vehicleId;
    @Column
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;


    @Column


    private String vehicleNumber;
    @Column
    private String vehicleCompany;
    @Column
    private String vehicleModel;



     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "user_id")
     private Users User_id;



    public Vehicle() {

        // TODO Auto-generated constructor stub
    }

    public Vehicle(VehicleType vehicleType, String vehicleNumber, String vehicleCompany, String vehicleModel) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleCompany = vehicleCompany;
        this.vehicleModel = vehicleModel;
    }

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private Users user_id;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleCompany() {
        return vehicleCompany;
    }

    public void setVehicleCompany(String vehicleCompany) {
        this.vehicleCompany = vehicleCompany;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }


    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", vehicleCompany="
                + vehicleCompany + ", vehicleModel=" + vehicleModel + "]";
    }


}

