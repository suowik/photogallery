package pl.edu.pk.ztbd.photogallery.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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

    public void init(String album){
        albumName = album;
    }


    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
