package spring.webapp.database.entity;

public class FlightDetailBuilder {
    private Integer flightID;
    private String startDestination;
    private String endDestination;
    private String arrivalDate;
    private String arrivalTime;
    private String departureDate;
    private String departureTime;
    private Integer seatLeft;
    private Integer seatMax;
    private String airline;
    private String flightNo;
    private float price;

    public FlightDetailBuilder setFlightID (Integer flightID) {
        this.flightID = flightID;
        return this;
    }

    public FlightDetailBuilder setStartDestination (String startDestination) {
        this.startDestination = startDestination;
        return this;
    }

    public FlightDetailBuilder setEndDestination (String endDestination) {
        this.endDestination = endDestination;
        return this;
    }

    public FlightDetailBuilder setArrivalDate (String arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    public FlightDetailBuilder setArrivalTime (String arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }
    public FlightDetailBuilder setDepartureTime (String departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public FlightDetailBuilder setDepartureDate (String departureDate) {
        this.departureDate = departureDate;
        return this;
    }
    public FlightDetailBuilder setSeatLeft (Integer seatLeft) {
        this.seatLeft = seatLeft;
        return this;
    }

    public FlightDetailBuilder setSeatMax (Integer seatMax) {
        this.seatMax = seatMax;
        return this;
    }

    public FlightDetailBuilder setAirline (String airline) {
        this.airline = airline;
        return this;
    }

    public FlightDetailBuilder setFlightNo (String flightNo) {
        this.flightNo = flightNo;
        return this;
    }

    public FlightDetailBuilder setPrice (float price) {
        this.price = price;
        return this;
    }

}
