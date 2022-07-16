package org.sahaj.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingLotTest {

    private ParkingLot.Builder parkingLotBuilder;

    @BeforeEach
    void setUp() {
        this.parkingLotBuilder = new ParkingLot.Builder().withLargeSpots(2).withMediumSpots(5).withSmallSpots(10);
    }

    @Test
    void shouldAllocateParkingSpotAndReturnTicketForACarWhenSpotAvailable() {
        ParkingLot parkingLot = this.parkingLotBuilder.build();
        Vehicle car = Vehicle.CAR;
        Ticket ticket = parkingLot.park(car);

        assertEquals(0, ticket.getId());
    }

    @Test
    void shouldUnParkAParkedCarFromAGivenTicket() {
        ParkingLot parkingLot = this.parkingLotBuilder.build();
        Vehicle car = Vehicle.CAR;
        Ticket ticket = parkingLot.park(car);

        assertEquals(car, parkingLot.unPark(ticket).forVehicle());
    }

    @Test
    void shouldTrackSpotOccupancyByVehicleType() {
        ParkingLot parkingLot = this.parkingLotBuilder.withMediumSpots(1).withSmallSpots(1).build();
        Vehicle car = Vehicle.CAR;
        Vehicle bike = Vehicle.BIKE;
        Vehicle truck = Vehicle.TRUCK;

        assertEquals(0, parkingLot.park(car).getId());
        assertEquals(1, parkingLot.park(bike).getId());
        assertEquals(2, parkingLot.park(truck).getId());
    }

    @Test
    void shouldUnParkAndUnParkFixedNumberOfCars() {
        ParkingLot parkingLot = this.parkingLotBuilder.withMediumSpots(3).withSmallSpots(0).withLargeSpots(0).build();

        Ticket ticketOne = parkingLot.park(Vehicle.CAR);
        Ticket ticketTwo = parkingLot.park(Vehicle.CAR);
        Ticket ticketThree = parkingLot.park(Vehicle.CAR);

        parkingLot.unPark(ticketOne);
        parkingLot.unPark(ticketOne);
        parkingLot.unPark(ticketTwo);
        parkingLot.unPark(ticketThree);

        assertEquals(3, parkingLot.totalSpotCount());
    }

    @Test
    void shouldGenerateReceiptWithFlatFeeByVehicleTypeOnUnPark() {
        ParkingLot parkingLot = this.parkingLotBuilder.build();
        Vehicle car = Vehicle.CAR;
        Ticket ticket = parkingLot.park(car);

        Receipt receipt = parkingLot.unPark(ticket);

        assertEquals(200, receipt.getParkingCharges());
    }

    @Test
    void shouldApplyFlatRateMultiplierAcrossAllVehicleTypes() {
        ParkingLot parkingLot = this.parkingLotBuilder.build();
        Vehicle car = Vehicle.CAR;
        Vehicle bike = Vehicle.BIKE;
        Vehicle truck = Vehicle.TRUCK;

        Receipt carFare = parkingLot.unPark(parkingLot.park(car));
        Receipt truckFare = parkingLot.unPark(parkingLot.park(truck));
        Receipt bikeFare = parkingLot.unPark(parkingLot.park(bike));

        assertEquals(bikeFare.getParkingCharges() * 3, truckFare.getParkingCharges());
        assertEquals(bikeFare.getParkingCharges() * 2, carFare.getParkingCharges());
    }
}