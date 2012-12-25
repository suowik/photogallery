package pl.edu.pk.ztbd.photogallery.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 25.12.12
 * Time: 14:05
 */
public class AlbumDAOFactory {
    private AlbumDAOFactory(){}
    public static AlbumDAO create(){
        return new AlbumDAOImpl();
    }
}
