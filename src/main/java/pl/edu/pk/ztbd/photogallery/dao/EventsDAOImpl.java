package pl.edu.pk.ztbd.photogallery.dao;

import oracle.jdbc.OracleTypes;
import org.jetbrains.annotations.NotNull;
import pl.edu.pk.ztbd.photogallery.db.ConnectionResolver;
import pl.edu.pk.ztbd.photogallery.exceptions.UserNotFoundException;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Event;
import pl.edu.pk.ztbd.photogallery.to.EventType;
import pl.edu.pk.ztbd.photogallery.to.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: msendyka
 * Date: 12.01.13
 * Time: 16:43
 */
public class EventsDAOImpl implements EventsDAO {
    private static final String FIND_ALL = "{call events_management.findALl(?)}";
    @NotNull
    @Override
    public List<Event> findAll() {
        List<Event> result = new ArrayList<Event>();

        Connection connection = ConnectionResolver.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_ALL);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.executeUpdate();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            while (rs.next()) {
                Event event = new Event(rs.getString(1), getEvent(rs.getString(2)), rs.getTimestamp(3));
                result.add(event);
            }
            rs.close();
            callableStatement.close();
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

    private EventType getEvent(String eventKey) {
        return EventType.valueOf(eventKey);
    }
}
