package pl.edu.pk.ztbd.photogallery.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:36
 */
public interface AlbumDAO {
    void add(@NotNull Album album);
    void remove(String name);
    @NotNull
    List<Photo> findPhotos(@NotNull Album album, int count, int offset);
}