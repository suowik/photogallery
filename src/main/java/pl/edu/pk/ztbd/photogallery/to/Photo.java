package pl.edu.pk.ztbd.photogallery.to;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: PS
 * Date: 08.12.12
 * Time: 17:44
 * To change this template use File | Settings | File Templates.
 */
public class Photo implements Serializable {
    private long photoId;
    private long albumId;
    private String title;
    private String filename;
    private String description;
    private String auditCreate;
    private String place;

    public Photo() {
    }

    public String imagePath(){
        return "/photos/"+filename;
    }

    public Photo(String filename) {
        this.filename = filename;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuditCreate() {
        return auditCreate;
    }

    public void setAuditCreate(String auditCreate) {
        this.auditCreate = auditCreate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;

        Photo photo = (Photo) o;

        if (albumId != photo.albumId) return false;
        if (photoId != photo.photoId) return false;
        if (!auditCreate.equals(photo.auditCreate)) return false;
        if (!description.equals(photo.description)) return false;
        if (!filename.equals(photo.filename)) return false;
        if (!place.equals(photo.place)) return false;
        if (!title.equals(photo.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (photoId ^ (photoId >>> 32));
        result = 31 * result + (int) (albumId ^ (albumId >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + filename.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + auditCreate.hashCode();
        result = 31 * result + place.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", albumId=" + albumId +
                ", title='" + title + '\'' +
                ", filename='" + filename + '\'' +
                ", description='" + description + '\'' +
                ", auditCreate='" + auditCreate + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}


