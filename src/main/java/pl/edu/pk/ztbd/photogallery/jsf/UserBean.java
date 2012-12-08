package pl.edu.pk.ztbd.photogallery.jsf;

import pl.edu.pk.ztbd.photogallery.dao.UserDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean {
    public void tryMe(ActionEvent evt){
        UserDAO userDAO = new UserDAO();
        userDAO.tryMe();
    }
}
