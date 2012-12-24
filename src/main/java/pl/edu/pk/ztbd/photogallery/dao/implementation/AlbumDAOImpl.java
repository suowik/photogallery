package pl.edu.pk.ztbd.photogallery.dao.implementation;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.dao.AlbumDAO;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:53
 */
public class AlbumDAOImpl implements AlbumDAO {
    @Override
    public void add(@NotNull Album album) {
    }

    @Override
    public void remove(String name) {
    }

    @NotNull
    @Override
    public List<Photo> findPhotos(@NotNull Album album, int count, int offset) {
        return null;
    }
}
