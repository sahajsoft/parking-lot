package org.sahaj.parkinglot;

public class Spot {

    private Vehicle carType;

    public Spot(final Vehicle carType) {
        this.carType = carType;
    }

    public Vehicle getCarType() {
        return carType;
    }

}
