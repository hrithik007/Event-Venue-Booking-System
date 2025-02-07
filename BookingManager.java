import java.util.*;

public class BookingManager {
    private Map<String, Booking> bookings = new HashMap<>();
    private EventManager eventManager;

    BookingManager(EventManager eventManager){
        this.eventManager = eventManager;
    }


    public void bookEvent(String customerId, String eventId) {
        Event event = eventManager.getEvent(eventId);
        if(event == null){
            System.out.println("No event found for this evant id :"+ eventId);
            return;
        }
        if (event.getBookedCount()==event.getMaxParticipants()) {
            event.addToWaitlist(customerId);
            System.out.println("Event :"+eventId+" reached max capacity adding customer -"+ customerId +" to waiting list");
        } else {
            Booking booking = new Booking(UUID.randomUUID().toString(), customerId, event.getId());
            bookings.put(booking.getBookingId(), booking);
            event.incrementBookedCount();
            System.out.println("Event Booked for customer "+ customerId+ " for event "+ eventId);
        }
    }

    public List<Booking> getCustomerBookings(String customerId){
        List<Booking> customerBookings = new ArrayList<>();
        for(Booking booking:bookings.values())
        {
            if(booking.getCustomerId().equalsIgnoreCase(customerId)){
            customerBookings.add(booking);
            }
        }
         return customerBookings;
    }

    public void printCustormerBookings(String customerId) {
        if (getCustomerBookings(customerId).isEmpty()) {
            System.out.println("No booking found of customer :" + customerId);
            return;
        }
        for(Booking booking : getCustomerBookings(customerId)){
                System.out.println("Customer :"+ customerId+" bookings :-");
                System.out.println(booking.toString());
            };
        }



    public void cancelBooking(String customerId) {
        int count = 0;
        for (Booking booking : getCustomerBookings(customerId)){
            eventManager.decrementEventCapacity(booking.eventId);
            bookings.remove(booking.getBookingId());
            count++;
            Event event = eventManager.getEvent(booking.eventId);
            if(event.getBookedCount()<event.getMaxParticipants()){
                String waitingCustomer = event.waitingList.poll();
                System.out.println("Booking canceled for customer :"+customerId);
                bookEvent(waitingCustomer,event.getId());
                eventManager.incrementEventCapacity(event.getId());
            }
    }
    }

    public void removeEvent(String eventId){
       eventManager.removeEvent(eventId);
       for(Booking booking : bookings.values()){
           if(booking.eventId.equalsIgnoreCase(eventId)){
               bookings.remove(booking.getBookingId());
           }
       }
    }


    public void trendingEvents(int topN) {
        // Create a list to store events with their booking percentage
        List<BookingManager.EventBookingInfo> eventBookingInfoList = new ArrayList<>();

        // Calculate booking percentage for each event
        for (Event event : eventManager.getAllEvents()) {
            double bookingPercentage = ((double) event.getBookedCount() / event.getMaxParticipants()) * 100;
            eventBookingInfoList.add(new BookingManager.EventBookingInfo(event, bookingPercentage));
        }

        // Sort the list by booking percentage in descending order
        eventBookingInfoList.sort((e1, e2) -> Double.compare(e2.getBookingPercentage(), e1.getBookingPercentage()));

        // Print the top N events based on booking percentage
        for (int i = 0; i < topN && i < eventBookingInfoList.size(); i++) {
            BookingManager.EventBookingInfo info = eventBookingInfoList.get(i);
            Event event = info.getEvent();
            System.out.println("Event: " + event.getName() + " | Booked: " + info.getBookingPercentage() + "%");
        }
    }

    private class EventBookingInfo {
        private Event event;
        private double bookingPercentage;

        public EventBookingInfo(Event event, double bookingPercentage) {
            this.event = event;
            this.bookingPercentage = bookingPercentage;
        }

        public Event getEvent() {
            return event;
        }

        public double getBookingPercentage() {
            return bookingPercentage;
        }
    }
}
