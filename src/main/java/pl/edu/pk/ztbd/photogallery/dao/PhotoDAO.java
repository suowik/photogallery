package pl.edu.pk.ztbd.photogallery.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.to.Photo;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:36
 */
public interface PhotoDAO {
    void add(@NotNull Photo photo);
    void remove(String name);
}
