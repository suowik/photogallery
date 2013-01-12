package pl.edu.pk.ztbd.photogallery.to;

import java.util.Date;

/**
 * User: msendyka
 * Date: 12.01.13
 * Time: 16:38
 */
public class Event {
    private final String email;
    private final EventType eventType;
    private final Date eventDate;

    public Event(String email, EventType eventType, Date eventDate) {
        this.email = email;
        this.eventType = eventType;
        this.eventDate = eventDate;
    }

    public String getEmail() {
        return email;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Date getEventDate() {
        return eventDate;
    }
}
