import java.util.*;
import java.time.LocalTime;
class Event {
    private String id;
    private String name;
    private String venueId;
    private String eventType;
    private int maxParticipants;
    private LocalTime startTime;
    private LocalTime endTime;
    private double ticketPrice;
    private int bookedCount;
    Queue<String> waitingList;

    public Event(String id, String name, String venueId, String eventType, int maxParticipants,
                 LocalTime startTime, LocalTime endTime, double ticketPrice) {
        this.id = id;
        this.name = name;
        this.venueId = venueId;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.bookedCount = 0;
        this.waitingList = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVenueId() {
        return venueId;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getBookedCount() {
        return bookedCount;
    }

    public void incrementBookedCount() {
        bookedCount++;
    }
    public void decrementBookedCount() {
        bookedCount--;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void addToWaitlist(String customerId){
        waitingList.add(customerId);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", venueId='" + venueId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", maxParticipants=" + maxParticipants +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", ticketPrice=" + ticketPrice +
                ", bookedCount=" + bookedCount +
                ", waitingList=" + waitingList +
                '}';
    }
}
