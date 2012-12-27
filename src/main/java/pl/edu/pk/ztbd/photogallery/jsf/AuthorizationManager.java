package pl.edu.pk.ztbd.photogallery.jsf;

import pl.edu.pk.ztbd.photogallery.dao.UserDAO;
import pl.edu.pk.ztbd.photogallery.dao.UserDAOFactory;
import pl.edu.pk.ztbd.photogallery.exceptions.UserNotFoundException;
import pl.edu.pk.ztbd.photogallery.to.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "authorizationManager")
@SessionScoped
public class AuthorizationManager {
    private UserDAO userDAO = UserDAOFactory.create();
    private User user;
    private String login;
    private String password;

    public void login(ActionEvent event) {
        try {
            user = userDAO.login(login, password);
            redirectToAlbums();
        } catch (UserNotFoundException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd logowania", "Niepoprawne dane"));
        }
    }

    private void redirectToAlbums(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("albums.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout(ActionEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticated() {
        return user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
