package pl.edu.pk.ztbd.photogallery.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "albumsManager")
@ViewScoped
public class AlbumsManager {

    private String user;

    public void init(String email){
        user = email;
    }

    public void test(ActionEvent event){
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(user));
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
