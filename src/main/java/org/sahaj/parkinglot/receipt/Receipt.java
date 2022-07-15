package org.sahaj.parkinglot.receipt;

import org.sahaj.parkinglot.vehicle.Vehicle;

public class Receipt {
    private Double parkingCharges;
    private Vehicle vehicle;

    public Receipt(Integer parkingCharges, Vehicle vehicle) {
        this.parkingCharges = Double.valueOf(parkingCharges.toString());
        this.vehicle = vehicle;
    }

    public Vehicle forVehicle() {
        return this.vehicle;
    }

    public Double getParkingCharges() {
        return this.parkingCharges;
    }
}
