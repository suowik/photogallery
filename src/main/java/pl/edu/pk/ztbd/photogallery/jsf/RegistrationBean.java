package pl.edu.pk.ztbd.photogallery.jsf;

import pl.edu.pk.ztbd.photogallery.dao.UserDAO;
import pl.edu.pk.ztbd.photogallery.dao.UserDAOFactory;
import pl.edu.pk.ztbd.photogallery.exceptions.UserExistsException;
import pl.edu.pk.ztbd.photogallery.to.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 05.01.13
 * Time: 11:59
 */
@ManagedBean(name="registrationBean")
@ViewScoped
public class RegistrationBean implements Serializable {
    private UserDAO userDAO = UserDAOFactory.create();
    private User user = new User();

    public void register(ActionEvent event){
        try {
            userDAO.register(user);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Zarejestrowano"));
        } catch (UserExistsException e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Użytkownik isnieje"));
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
