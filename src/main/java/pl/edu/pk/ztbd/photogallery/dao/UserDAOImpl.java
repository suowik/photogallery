package pl.edu.pk.ztbd.photogallery.dao;

import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.db.ConnectionResolver;
import pl.edu.pk.ztbd.photogallery.exceptions.UserExistsException;
import pl.edu.pk.ztbd.photogallery.exceptions.UserNotFoundException;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 24.12.12
 * Time: 13:41
 */
class UserDAOImpl implements UserDAO {
    private static final String LOGIN = "{call ? = user_management.login(?,?)}";
    private static final String REGISTER = "{call user_management.register(?,?,?,?)}";
    private static final String REMOVE = "{call user_management.remove(?)}";
    private static final String FIND_ALBUMS = "{call ? = user_management.find_albums(?,?,?)}";
    private static final String NAME = "NAME";
    private static final String SURNAME = "SURNAME";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";
    private Connection connection = ConnectionResolver.getConnection();

    @NotNull
    @Override
    public User login(String mail, String password) throws UserNotFoundException {
        try {
            CallableStatement callableStatement = prepareCall(LOGIN);
            callableStatement.registerOutParameter(1, Types.OTHER);
            callableStatement.setString(2, mail);
            callableStatement.setString(3, password);
            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            return convertResultSetToUser(rs);
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

    private User convertResultSetToUser(ResultSet rs) throws SQLException {
        return new User(rs.getString(EMAIL), rs.getString(NAME), rs.getString(SURNAME), rs.getString(PASSWORD));
    }

    @Override
    public void register(User user) throws UserExistsException {
        try {
            CallableStatement callableStatement = prepareCall(REGISTER);
            callableStatement.setString(1, user.getEmail());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getSurname());
            callableStatement.setString(4, user.getPassword());
            callableStatement.execute();
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

    @Override
    public void delete(String mail) {
        try {
            CallableStatement callableStatement = prepareCall(REMOVE);
            callableStatement.setString(1, mail);
            callableStatement.execute();
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

    @NotNull
    @Override
    public List<Album> findAlbums(@NotNull User user, int count, int offset) {
        List<Album> result = new ArrayList<Album>();
        try {
            CallableStatement callableStatement = prepareCall(FIND_ALBUMS);
            callableStatement.registerOutParameter(1, Types.OTHER);
            callableStatement.setString(2, user.getEmail());
            callableStatement.setInt(3, count);
            callableStatement.setInt(4, offset);
            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            fillAlbums(result, rs);
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

    private void fillAlbums(List<Album> result, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Album album = new Album(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5));
            result.add(album);
        }
    }

    private CallableStatement prepareCall(String sql) throws SQLException {
        return connection.prepareCall(sql);
    }
}
