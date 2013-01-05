package pl.edu.pk.ztbd.photogallery.dao;

import oracle.jdbc.OracleTypes;
import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.db.ConnectionResolver;
import pl.edu.pk.ztbd.photogallery.exceptions.UserExistsException;
import pl.edu.pk.ztbd.photogallery.exceptions.UserNotFoundException;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.User;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:41
 */
class UserDAOImpl implements UserDAO, Serializable {
    private static final String LOGIN = "{call user_management.login(?,?,?,?)}";
    private static final String REGISTER = "{call user_management.register(?,?,?,?)}";
    private static final String REMOVE = "{call user_management.remove(?)}";
    private static final String FIND_ALBUMS = "{call user_management.findAlbums(?,?)}";

    @NotNull
    @Override
    public User login(String mail, String password) throws UserNotFoundException {
        Connection connection = ConnectionResolver.getConnection();
        try {
            return login(mail, password, connection);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserNotFoundException();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private User login(String mail, String password, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(LOGIN);
        callableStatement.setString(1, mail);
        callableStatement.setString(2, password);
        callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
        callableStatement.registerOutParameter(4, OracleTypes.VARCHAR);
        callableStatement.execute();
        return new User(callableStatement.getString(3),callableStatement.getString(4),mail,password);
    }

    @Override
    public void register(User user) throws UserExistsException {
        Connection connection = ConnectionResolver.getConnection();
        try {
            register(user, connection);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserExistsException();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void register(User user, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(REGISTER);
        callableStatement.setString(1, user.getName());
        callableStatement.setString(2, user.getSurname());
        callableStatement.setString(3, user.getEmail());
        callableStatement.setString(4, user.getPassword());
        callableStatement.execute();
    }

    @Override
    public void delete(String mail) {
        Connection connection = ConnectionResolver.getConnection();
        try {
            delete(mail, connection);
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

    private void delete(String mail, Connection connection) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(REMOVE);
        callableStatement.setString(1, mail);
        callableStatement.execute();
    }

    @NotNull
    @Override
    public List<Album> findAlbums(String email) {
        List<Album> result = new ArrayList<Album>();
        Connection connection = ConnectionResolver.getConnection();
        try {
            findAlbums(email,connection,result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private void findAlbums(String email, Connection connection, List<Album> albums) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall(FIND_ALBUMS);
        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
        callableStatement.setString(1, email);
        callableStatement.executeUpdate();
        ResultSet rs = (ResultSet) callableStatement.getObject(2);
        fillAlbums(albums, rs);
        callableStatement.close();
    }

    private void fillAlbums(List<Album> result, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Album album = new Album(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
            result.add(album);
        }
        rs.close();
    }

}
