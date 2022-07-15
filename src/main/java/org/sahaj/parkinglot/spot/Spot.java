package org.sahaj.parkinglot.spot;

import org.sahaj.parkinglot.vehicle.Vehicle;

public class Spot {

    private Vehicle carType;

    public Spot(final Vehicle carType) {
        this.carType = carType;
    }

    public Vehicle getCarType() {
        return carType;
    }

}
