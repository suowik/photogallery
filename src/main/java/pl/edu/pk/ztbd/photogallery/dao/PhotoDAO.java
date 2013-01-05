package pl.edu.pk.ztbd.photogallery.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;
import pl.edu.pk.ztbd.photogallery.to.User;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:36
 */
public interface PhotoDAO {
    void add(@NotNull User user, @NotNull Album album, @NotNull Photo photo);
    void remove(String name);
}
