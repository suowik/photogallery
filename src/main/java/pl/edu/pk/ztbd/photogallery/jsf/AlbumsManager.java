package pl.edu.pk.ztbd.photogallery.jsf;

import pl.edu.pk.ztbd.photogallery.to.Album;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "albumsManager")
@ViewScoped
public class AlbumsManager implements Serializable {

    private String user;
    private List<Album> albums;
    private Album newAlbum = new Album();

    public void addAlbum(ActionEvent event){
        albums.add(newAlbum);
        newAlbum = new Album();
    }

    public void init(String email){
        user = email;
        albums = loadAlbums(email);
    }

    private List<Album> loadAlbums(String email){
        return new ArrayList<Album>();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Album getNewAlbum() {
        return newAlbum;
    }

    public void setNewAlbum(Album newAlbum) {
        this.newAlbum = newAlbum;
    }
}
