package pl.edu.pk.ztbd.photogallery.jsf;

import pl.edu.pk.ztbd.photogallery.dao.AlbumDAO;
import pl.edu.pk.ztbd.photogallery.dao.AlbumDAOFactory;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 09.12.12
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "photoManager")
@ViewScoped
public class PhotoManager {
    private String albumName;
    private AlbumDAO albumDAO = AlbumDAOFactory.create();
    private List<Photo> photos;

    @ManagedProperty("#{authorizationManager}")
    private AuthorizationManager authorizationManager;

    public void init(){
        photos = loadPhotos();
    }

    private List<Photo> loadPhotos() {
        return albumDAO.findPhotos(authorizationManager.getUser().getEmail(),albumName);
    }

    public Album getCurrentAlbum(){
        return new Album(albumName);
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public AuthorizationManager getAuthorizationManager() {
        return authorizationManager;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
