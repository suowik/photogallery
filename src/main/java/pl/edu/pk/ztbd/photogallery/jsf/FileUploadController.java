package pl.edu.pk.ztbd.photogallery.jsf;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import pl.edu.pk.ztbd.photogallery.directoryutils.Directories;
import pl.edu.pk.ztbd.photogallery.directoryutils.DirectoryCreator;
import pl.edu.pk.ztbd.photogallery.imageutils.Dimensions;
import pl.edu.pk.ztbd.photogallery.imageutils.ImageResizer;
import pl.edu.pk.ztbd.photogallery.to.Photo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
    @ManagedProperty("#{authorizationManager}")
    private AuthorizationManager authorizationManager;

    private String album;

    public void handleFileUpload(FileUploadEvent event) {
        createDirectories();
        resizeAndSaveImages(event.getFile());
        photosContainer.add(new Photo(event.getFile().getFileName()));
    }

    private void createDirectories() {
        DirectoryCreator.createDirectories(bigImageDirectory());
        DirectoryCreator.createDirectories(smallImageDirectory());
    }

    private void resizeAndSaveImages(UploadedFile file) {
        BufferedImage bigImage = resize(file,Dimensions.BIG_IMAGE);
        BufferedImage smallImage = resize(file,Dimensions.SMALL_IMAGE);
        OutputStream bigImageOS = null;
        OutputStream smallImageOS = null;
        try {
            bigImageOS = new FileOutputStream(bigImageDirectory()+"/"+file.getFileName());
            smallImageOS = new FileOutputStream(smallImageDirectory()+"/"+file.getFileName());
            ImageIO.write(bigImage,getExtension(file.getFileName()),bigImageOS);
            ImageIO.write(smallImage,getExtension(file.getFileName()),smallImageOS);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (smallImageOS != null) {
                try {
                    smallImageOS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bigImageOS != null) {
                try {
                    bigImageOS.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private BufferedImage resize(UploadedFile file, Dimensions dimensions) {
        try {
            return  ImageResizer.resize(file.getInputstream(), dimensions);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private String getExtension(String filename){
        return filename.split("\\.")[1];
    }

    private String smallImageDirectory(){
        return commonDirectory()+"/min/";
    }

    private String bigImageDirectory(){
        return commonDirectory()+"/big/";
    }

    private String commonDirectory(){
        return Directories.PHOTOS_DIRECTORY+"/"+authorizationManager.getUser().getEmail()+"/"+album;
    }

    public PhotosContainer getPhotosContainer() {
        return photosContainer;
    }

    public void setPhotosContainer(PhotosContainer photosContainer) {
        this.photosContainer = photosContainer;
    }

    public AuthorizationManager getAuthorizationManager() {
        return authorizationManager;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
