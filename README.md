# Event Venue Booking System

## Overview

The **Event Venue Booking System** is a comprehensive platform designed to streamline the management of event venues, providing admins with the ability to manage venue details and events, while offering customers an easy way to book venues and check event availability. This system supports various use cases, including event searching, booking, trending events, and a waiting list feature for full events.

## Features

### Admin Features:
- **Add Venue:** Admin can add new venues by specifying venue details such as name, location, and maximum capacity.
- **Remove Venue:** Admin can remove venues, which also cancels all events scheduled at that venue.
- **Add Event:** Admin can create events at specific venues, specifying event type, max participants, start and end time, and ticket price.
- **Remove Event:** Admin can remove events, canceling all bookings associated with that event.

### Customer Features:
- **Search Events by Type:** Customers can search for venues hosting specific types of events (e.g., weddings, conferences, standups).
- **View Events at a Venue:** Customers can view all events scheduled at a particular venue.
- **Book Events:** Customers can book spots for available events. Booking is restricted to the venue's capacity.
- **Trending Events:** Display the top N events based on booking percentage.
- **View Bookings:** Customers can view all the events they have booked.
- **Cancel Booking:** Customers can cancel their event bookings.
- **Waiting List:** If an event is fully booked, customers can be added to the waiting list, automatically booking them when a spot becomes available.

### Extra Features:
- **Search and Sort:** Enhanced search functionality with sorting options (e.g., sort by earliest event, price).
- **In-Memory Data Storage:** All data is stored in memory, ensuring fast processing and no need for a database.
  
## Sample Test Case

```bash
> addVenue(v_id_001, SarjapurSocial, Bengaluru, 200)
>> Venue SarjapurSocial added to Bengaluru

> addEvent(e_id_001, MaiSamayHoon, v_id_001, StandUp, 100, 19:00, 21:00, 500)
>> Created an event: e_id_001 at the venue: v_id_001

> bookEvent(c_id_001, e_id_001)
>> Booking Success

> getAllBookings(c_id_001)
>> c_id_001: booking at venue SarjapurSocial, Bengaluru for the event MaiSamayHoon from 19:00 to 21:00
