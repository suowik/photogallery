package pl.edu.pk.ztbd.photogallery.imageutils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 06.01.13
 * Time: 11:36
 */
public class ImageResizer {
    public static BufferedImage resize(InputStream image, Dimensions dimensions){
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int type = 0;
        if (originalImage != null) {
            type = originalImage.getType();
        }
        return resizeImage(originalImage,type,dimensions);
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type, Dimensions dimensions){
        BufferedImage resizedImage = new BufferedImage(dimensions.getWidth(), dimensions.getHeight(), type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, dimensions.getWidth(), dimensions.getHeight(), null);
        g.dispose();
        return resizedImage;
    }
}
