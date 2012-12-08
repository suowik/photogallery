package pl.edu.pk.ztbd.photogallery.dao;

import pl.edu.pk.ztbd.photogallery.db.ConnectionResolver;
import pl.edu.pk.ztbd.photogallery.exceptions.UserNotFoundException;
import pl.edu.pk.ztbd.photogallery.to.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    User login(String mail, String password) throws UserNotFoundException;
    void register(User user);
    void delete(User user);
}
