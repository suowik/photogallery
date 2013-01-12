package pl.edu.pk.ztbd.photogallery.dao;

import pl.edu.pk.ztbd.photogallery.to.Event;

import java.util.List;

/**
 * User: msendyka
 * Date: 12.01.13
 * Time: 16:37
 */
public interface EventsDAO {
    List<Event> findAll();
}
