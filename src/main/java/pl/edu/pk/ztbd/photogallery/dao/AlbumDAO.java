package pl.edu.pk.ztbd.photogallery.dao;

import pl.edu.pk.ztbd.photogallery.to.Album;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:36
 */
public interface AlbumDAO {
    void add(Album album);
    void remove(String name);
}
