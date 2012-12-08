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
    public static Connection getConnection() {
        Connection conn = null;
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/photogallery");
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
