package pl.edu.pk.ztbd.photogallery.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 25.12.12
 * Time: 14:03
 */
public class PhotoDAOFactory {
    private PhotoDAOFactory(){}
    public static PhotoDAO create(){
        return new PhotoDAOImpl();
    }
}
