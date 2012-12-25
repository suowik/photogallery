package pl.edu.pk.ztbd.photogallery.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 25.12.12
 * Time: 14:02
 */
public class UserDAOFactory {
    private UserDAOFactory(){}
    public static UserDAO create(){
        return new UserDAOImpl();
    }
}
