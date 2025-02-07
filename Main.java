import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        //Venue Manager Manges venue
        VenueManager venueManager = new VenueManager();
        venueManager.addVenue("venue_id_1", "Narendra Modi Stadium", "Gujjarat", 2);

        //Event Manager manges events
        EventManager eventManager = new EventManager(venueManager);
        eventManager.addEvent("event_id_1", "ColdPlay", "Concert", "venue_id_1", 1, LocalTime.of(19, 0), LocalTime.of(21, 0), 500);
        eventManager.getAllEvents();

       //Booking Manager manages booking
        BookingManager bookingManager = new BookingManager(eventManager);
        bookingManager.bookEvent("C1","event_id_1");
        bookingManager.bookEvent("C2","event_id_1");


        bookingManager.printCustormerBookings("C1");

        //If a Event Booking of customer is canceled and then booking is made if there is waiting customer for the evant
        bookingManager.cancelBooking("C1");
        bookingManager.printCustormerBookings("C1");
        bookingManager.printCustormerBookings("C2");

        //Top trending events based on number of Bookings
        bookingManager.trendingEvents(5);

        //canceling event which removes evant and booking made to the evant
        bookingManager.removeEvent("event_id_1");
        eventManager.getEvent("event_id_1");
        bookingManager.printCustormerBookings("C2");



    }
}