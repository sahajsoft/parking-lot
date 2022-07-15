package org.sahaj.parkinglot.ticket;

import org.sahaj.parkinglot.spot.Spot;
import org.sahaj.parkinglot.vehicle.Vehicle;

public class Ticket {

    private final Integer id;
    private final Spot spot;
    private final Vehicle vehicle;

    public Ticket(Integer id, Spot spot, Vehicle vehicle) {
        this.id = id;
        this.spot = spot;
        this.vehicle = vehicle;
    }

    public Integer getId() {
        return this.id;
    }

    public Spot getSpot() {
        return this.spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
