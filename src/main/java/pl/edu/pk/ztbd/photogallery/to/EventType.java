package pl.edu.pk.ztbd.photogallery.to;

/**
 * User: msendyka
 * Date: 12.01.13
 * Time: 16:40
 */
public enum EventType {
    USER_LOGGED_IN("zalogował się"),
    ALBUM_CREATED("utworzył album"),
    PHOTO_ADDED("dodał zdjęcie"),
    USER_CREATED("założył konto");

    private String eventDesc;


    private EventType(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventDesc() {
        return eventDesc;
    }
}
