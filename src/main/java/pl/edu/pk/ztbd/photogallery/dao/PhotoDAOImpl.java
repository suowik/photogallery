package pl.edu.pk.ztbd.photogallery.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.db.ConnectionResolver;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;
import pl.edu.pk.ztbd.photogallery.to.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:51
 */
class PhotoDAOImpl implements PhotoDAO {

    private final static String ADD_PHOTO = "{call photo_management.add(?,?,?,?,?,?)}";

    @Override
    public void add(User user, Album album, @NotNull Photo photo) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            add(user,album,photo,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void add(User user, Album album, Photo photo, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(ADD_PHOTO);
        callableStatement.setString(1,user.getEmail());
        callableStatement.setString(2,album.getName());
        callableStatement.setString(3,photo.getTitle());
        callableStatement.setString(4,photo.getFilename());
        callableStatement.setString(5,photo.getDescription());
        callableStatement.setString(6,photo.getPlace());
        callableStatement.execute();
    }

    @Override
    public void remove(String name) {
    }
}
