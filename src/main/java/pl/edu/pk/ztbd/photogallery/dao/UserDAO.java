package pl.edu.pk.ztbd.photogallery.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.exceptions.UserExistsException;
import pl.edu.pk.ztbd.photogallery.exceptions.UserNotFoundException;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    @NotNull
    User login(String mail, String password) throws UserNotFoundException;
    void register(User user) throws UserExistsException;
    void delete(String mail);
    @NotNull
    List<Album> findAlbums(String email);
}
