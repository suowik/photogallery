package pl.edu.pk.ztbd.photogallery.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.db.ConnectionResolver;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:53
 */
class AlbumDAOImpl implements AlbumDAO {

    private final static String ADD_ALBUM = "{call album_management.addalbum(?,?,?)}";

    @Override
    public void add(@NotNull Album album) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            add(album, connection);
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

    private void add(Album album, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(ADD_ALBUM);
        callableStatement.setString(1,album.getUserMail());
        callableStatement.setString(2,album.getName());
        callableStatement.setString(3,album.getDescription());
        callableStatement.execute();
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
