package pl.edu.pk.ztbd.photogallery.dao;

import pl.edu.pk.ztbd.photogallery.db.ConnectionResolver;

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
public class UserDAO {
    public void tryMe(){
        Connection connection = ConnectionResolver.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO USERS(email,name,surname,password) VALUES ('1234','aa','bb','cc')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
