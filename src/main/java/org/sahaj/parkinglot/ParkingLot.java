package org.sahaj.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class ParkingLot {

    private final List<Spot> spots;
    private Integer parkingSequenceNumber = 0;
    private ReceiptGenerator receiptGenerator;

    private ParkingLot(List<Spot> spots) {
        this.spots = spots;
        this.receiptGenerator = new ReceiptGenerator();
    }

    public Integer totalSpotCount() {
        return this.spots.size();
    }

    public Ticket park(final Vehicle vehicle) {
        Spot selectedSpot = null;
        for (Spot spot : spots) {
            if (spot.getCarType() == vehicle) {
                selectedSpot = spot;
            }
        }
        if (selectedSpot != null) spots.remove(selectedSpot);
        return new Ticket(parkingSequenceNumber++, selectedSpot, vehicle);
    }

    public Receipt unPark(final Ticket ticket) {
        spots.add(ticket.getSpot());
        return receiptGenerator.generate(ticket);
    }

    public static class Builder {

        public static final int DEFAULT_SPOT_COUNT = 10;
        private Integer smallParkingSpotCount = DEFAULT_SPOT_COUNT;
        private Integer mediumParkingSpotCount = DEFAULT_SPOT_COUNT;
        private Integer largeParkingSpotCount = DEFAULT_SPOT_COUNT;

        public Builder withSmallSpots(Integer count) {
            this.smallParkingSpotCount = count;
            return this;
        }

        public Builder withMediumSpots(Integer count) {
            this.mediumParkingSpotCount = count;
            return this;
        }

        public Builder withLargeSpots(Integer count) {
            this.largeParkingSpotCount = count;
            return this;
        }

        public ParkingLot build() {
            List<Spot> spots = new ArrayList<>();
            spots.addAll(IntStream.range(0, this.smallParkingSpotCount).mapToObj(i -> new Spot(Vehicle.BIKE)).collect(toSet()));
            spots.addAll(IntStream.range(0, this.mediumParkingSpotCount).mapToObj(i -> new Spot(Vehicle.CAR)).collect(toSet()));
            spots.addAll(IntStream.range(0, this.largeParkingSpotCount).mapToObj(i -> new Spot(Vehicle.TRUCK)).collect(toSet()));
            return new ParkingLot(spots);
        }

    }
}
