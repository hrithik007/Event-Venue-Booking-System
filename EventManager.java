import java.time.LocalTime;
import java.util.*;

public class EventManager {
    private VenueManager venueManager;

    public EventManager(VenueManager venueManager) {
        this.venueManager = venueManager;
    }

    public void addEvent(String eventId,String eventType, String name, String venueId, int maxParticipants, LocalTime startTime, LocalTime endTime, double ticketPrice) {
        Venue venue = venueManager.getVenue(venueId);
        if (venue == null) {
            throw new IllegalArgumentException("Venue not found.");
        }
        if (maxParticipants > venue.getMaxCapacity()) {
            throw new IllegalArgumentException("Participants exceed venue capacity.");
        }
        // Check capacity, overlapping events, etc.
        Event event = new Event(eventId, name, venueId, eventType, maxParticipants, startTime, endTime, ticketPrice);
        venue.addEvent(eventId,event);
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        for(Venue venue:venueManager.getAllVenue()) {
            for (Event event : venue.events.values()) {
                events.add(event);
            }
        }
        return events;
    }
    public Event getEvent(String evantId){
       Event events = getAllEvents().stream().filter(e->e.getId().equalsIgnoreCase(evantId)).findFirst().orElse(null);
       if(events == null) System.out.println("No Event found for event ID : "+evantId);
       return events;
    }

    public void decrementEventCapacity(String eventId){
       Event event = getEvent(eventId);
       if(event!=null) {
           event.decrementBookedCount();
       }
    }

    public void incrementEventCapacity(String eventId){
        Event event = getEvent(eventId);
        if(event!=null) {
            event.incrementBookedCount();
        }
    }

    public void removeEvent(String eventId){
        for(Venue venue : venueManager.getAllVenue()){
            for(Event event : venue.getAllEvent()){
                if(event.getId().equalsIgnoreCase(eventId)){
                    venue.removeEvent(eventId);
                }
            }
        }
    }

}
