package pl.edu.pk.ztbd.photogallery.dao;

import oracle.jdbc.OracleTypes;
import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.db.ConnectionResolver;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:53
 */
class AlbumDAOImpl implements AlbumDAO {

    private final static String ADD_ALBUM = "{call album_management.addAlbum(?,?,?)}";
    private final static String FIND_PHOTOS = "{call album_management.findPhotos(?,?,?)}";

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
        callableStatement.setString(1, album.getUserMail());
        callableStatement.setString(2, album.getName());
        callableStatement.setString(3, album.getDescription());
        callableStatement.execute();
    }

    @Override
    public void remove(String name) {
    }

    @NotNull
    @Override
    public List<Photo> findPhotos(String email, String album) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            return findPhotos(email, album, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<Photo>();
    }

    private List<Photo> findPhotos(String email, String album, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(FIND_PHOTOS);
        callableStatement.setString(1, email);
        callableStatement.setString(2, album);
        callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
        callableStatement.execute();
        return convertRSToList((ResultSet) callableStatement.getObject(3));
    }

    private List<Photo> convertRSToList(ResultSet rs) throws SQLException {
        List<Photo> photos = new ArrayList<Photo>();
        while (rs.next()) {
            Photo photo = new Photo();
            photo.setPhotoId(rs.getLong(1));
            photo.setAlbumId(rs.getLong(2));
            photo.setTitle(rs.getString(3));
            photo.setFilename(rs.getString(4));
            photo.setDescription(rs.getString(5));
            photo.setAuditCreate(rs.getString(6));
            photo.setPlace(rs.getString(7));
            photos.add(photo);
        }
        return photos;
    }
}
