package pl.edu.pk.ztbd.photogallery.jsf;

import pl.edu.pk.ztbd.photogallery.dao.PhotoDAO;
import pl.edu.pk.ztbd.photogallery.dao.PhotoDAOFactory;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import javax.faces.bean.ManagedBean;
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
    public PhotosContainer() {
        photos = new ArrayList<Photo>();
    }

    public void saveAll(ActionEvent event){
        System.out.println(photos);
        //persist
    }

    public void add(Photo photo){
        photoDAO.add(photo);
        photos.add(photo);
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
