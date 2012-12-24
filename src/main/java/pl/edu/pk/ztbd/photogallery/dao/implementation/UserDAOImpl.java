package pl.edu.pk.ztbd.photogallery.dao.implementation;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.dao.UserDAO;
import pl.edu.pk.ztbd.photogallery.exceptions.UserNotFoundException;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:41
 */
public class UserDAOImpl implements UserDAO {

    @NotNull
    @Override
    public User login(String mail, String password) throws UserNotFoundException {
        return null;
    }

    @Override
    public void register(User user) {
    }

    @Override
    public void delete(String mail) {
    }

    @NotNull
    @Override
    public List<Album> findAlbums(@NotNull User user, int count, int offset) {
        return null;
    }
}
