import java.util.*;
import java.time.LocalTime;

// Venue class
class Venue {
    private String id;
    private String name;
    private String location;
    private int maxCapacity;
    Map<String, Event> events;

    public Venue(String id, String name, String location, int maxCapacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.maxCapacity = maxCapacity;
        this.events = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public void addEvent(String evantId,Event event){
        events.put(evantId,event);
    }
    public void removeEvent(String evantId){
        events.remove(evantId);
    }
    public List<Event> getAllEvent(){
        return events.values().stream().toList();
    }
}