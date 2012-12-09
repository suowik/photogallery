package pl.edu.pk.ztbd.photogallery.to;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
public class Album implements Serializable {
    private long albumId;
    private String userMail;
    private String name;
    private Date auditCreate;
    private String description;

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuditCreate() {
        return auditCreate;
    }

    public void setAuditCreate(Date auditCreate) {
        this.auditCreate = auditCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
