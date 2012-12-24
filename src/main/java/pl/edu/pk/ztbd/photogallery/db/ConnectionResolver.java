package pl.edu.pk.ztbd.photogallery.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionResolver {
    private static final String DATASOURCE_LOCATION = "java:comp/env/jdbc/photogallery";
    public static Connection getConnection() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(DATASOURCE_LOCATION);
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        } catch (NamingException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
