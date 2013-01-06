package pl.edu.pk.ztbd.photogallery.imageutils;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 06.01.13
 * Time: 11:37
 */
public class Dimensions {
    private int width;
    private int height;

    public static final Dimensions BIG_IMAGE = new Dimensions(800, 600);
    public static final Dimensions SMALL_IMAGE = new Dimensions(300,200);

    public Dimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
