package pl.edu.pk.ztbd.photogallery.dao;

/**
 * User: msendyka
 * Date: 12.01.13
 * Time: 17:11
 */
public class EventsDaoFactory {
    private EventsDaoFactory(){}
    public static EventsDAO create(){
        return new EventsDAOImpl();
    }
}
