package pl.edu.pk.ztbd.photogallery.jsf;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 09.12.12
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "fileUploadController")
@ViewScoped
public class FileUploadController implements Serializable {

    @ManagedProperty("#{photosContainer}")
    private PhotosContainer photosContainer;

    public void handleFileUpload(FileUploadEvent event) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = event.getFile().getInputstream();
            os = new FileOutputStream("../webapps/photos/"+event.getFile().getFileName());
            IOUtils.copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        photosContainer.add(new Photo(event.getFile().getFileName()));
    }

    public PhotosContainer getPhotosContainer() {
        return photosContainer;
    }

    public void setPhotosContainer(PhotosContainer photosContainer) {
        this.photosContainer = photosContainer;
    }
}
