package pl.edu.pk.ztbd.photogallery.jsf;

import pl.edu.pk.ztbd.photogallery.dao.EventsDAO;
import pl.edu.pk.ztbd.photogallery.dao.EventsDaoFactory;
import pl.edu.pk.ztbd.photogallery.to.Event;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * User: msendyka
 * Date: 12.01.13
 * Time: 17:15
 */
@ManagedBean(name = "eventsManager")
@ViewScoped
public class EventsManager {
    private EventsDAO dao = EventsDaoFactory.create();
    private List<Event> events;
    public void init(){
        events = dao.findAll();
    }

    public List<Event> getEvents() {
        return events;
    }
}
