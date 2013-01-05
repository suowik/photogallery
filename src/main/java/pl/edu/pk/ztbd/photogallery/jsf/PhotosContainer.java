package pl.edu.pk.ztbd.photogallery.jsf;

import pl.edu.pk.ztbd.photogallery.dao.PhotoDAO;
import pl.edu.pk.ztbd.photogallery.dao.PhotoDAOFactory;
import pl.edu.pk.ztbd.photogallery.to.Album;
import pl.edu.pk.ztbd.photogallery.to.Photo;
import pl.edu.pk.ztbd.photogallery.to.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 09.12.12
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "photosContainer")
@ViewScoped
public class PhotosContainer implements Serializable {
    private List<Photo> photos;
    private PhotoDAO photoDAO = PhotoDAOFactory.create();

    @ManagedProperty("#{authorizationManager}")
    private AuthorizationManager authorizationManager;

    @ManagedProperty("#{photoManager}")
    private PhotoManager photoManager;

    public PhotosContainer() {
        photos = new ArrayList<Photo>();
    }

    public void addAllPhotos(ActionEvent event){
        for (Photo photo : photos) {
            persist(photo);
        }
        photos.clear();
    }

    public void addPhoto(ActionEvent event){
        Photo photo = (Photo) event.getComponent().getAttributes().get("photo");
        persist(photo);
        removePhotoByFilename(photo.getFilename());
    }


    private void removePhotoByFilename(String filename){
        for (int i = 0; i < photos.size(); i++) {
            Photo photo = photos.get(i);
            if(photo.getFilename().equals(filename)){
                photos.remove(i);
            }
        }
    }

    public void persist(Photo photo){
        User user = authorizationManager.getUser();
        Album currentAlbum = photoManager.getCurrentAlbum();
        photoDAO.add(user, currentAlbum, photo);
    }

    public void add(Photo photo){
        photos.add(photo);
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public AuthorizationManager getAuthorizationManager() {
        return authorizationManager;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }

    public PhotoManager getPhotoManager() {
        return photoManager;
    }

    public void setPhotoManager(PhotoManager photoManager) {
        this.photoManager = photoManager;
    }
}
