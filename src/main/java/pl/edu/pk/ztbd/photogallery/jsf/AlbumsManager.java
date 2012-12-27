package pl.edu.pk.ztbd.photogallery.jsf;

import org.w3c.dom.UserDataHandler;
import pl.edu.pk.ztbd.photogallery.dao.AlbumDAO;
import pl.edu.pk.ztbd.photogallery.dao.AlbumDAOFactory;
import pl.edu.pk.ztbd.photogallery.dao.UserDAO;
import pl.edu.pk.ztbd.photogallery.dao.UserDAOFactory;
import pl.edu.pk.ztbd.photogallery.to.Album;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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

    private String email;
    private List<Album> albums;
    private Album newAlbum = new Album();
    private UserDAO userDAO = UserDAOFactory.create();
    private AlbumDAO albumDAO = AlbumDAOFactory.create();


    public void addAlbum(ActionEvent event){
        albumDAO.add(newAlbum);
        newAlbum = new Album();
    }

    public void init(String email){
        this.email = email;
        albums = loadAlbums();
    }

    private List<Album> loadAlbums(){
        return userDAO.findAlbums(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
