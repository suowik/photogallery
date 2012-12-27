package pl.edu.pk.ztbd.photogallery.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:53
 */
class AlbumDAOImpl implements AlbumDAO {
    @Override
    public void add(@NotNull Album album) {
    }

    @Override
    public void remove(String name) {
    }

    @NotNull
    @Override
    public List<Photo> findPhotos(String album) {
        return null;
    }
}
