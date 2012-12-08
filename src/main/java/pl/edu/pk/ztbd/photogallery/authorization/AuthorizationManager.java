package pl.edu.pk.ztbd.photogallery.authorization;

import pl.edu.pk.ztbd.photogallery.dao.UserDAO;
import pl.edu.pk.ztbd.photogallery.exceptions.UserNotFoundException;
import pl.edu.pk.ztbd.photogallery.to.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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
    private UserDAO userDAO;
    private User user;
    private String login;
    private String password;

    public void login(ActionEvent evt){
        try {
            user = userDAO.login(login,password);
        } catch (UserNotFoundException e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Błąd","Nie udało się zalogować"));
        }
    }

    public void logout(ActionEvent event){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public boolean authenticated(){
        return user != null;
    }
}
