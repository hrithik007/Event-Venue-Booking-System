import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VenueManager {
    private Map<String, Venue> venues = new HashMap<>();

    public void addVenue(String venueId, String name, String location, int maxCapacity) {
        if (venues.containsKey(venueId)) {
            throw new IllegalArgumentException("Venue already exists.");
        }
        venues.put(venueId, new Venue(venueId, name, location, maxCapacity));
    }

    public Venue getVenue(String venueId) {
        return venues.get(venueId);
    }

    public List<Venue> getAllVenue(){
        List<Venue> venues1 = new ArrayList<>();
        for (Venue venue: venues.values()){
            venues1.add(venue);
        }
        return venues1;
    }

    // Other venue-related methods...
}
