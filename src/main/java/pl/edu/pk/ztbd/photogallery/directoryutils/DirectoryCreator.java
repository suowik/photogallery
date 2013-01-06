package pl.edu.pk.ztbd.photogallery.directoryutils;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 06.01.13
 * Time: 11:30
 */
public class DirectoryCreator {

    public static void createDirectories(String directories){
        new File(directories).mkdirs();
    }

    public static void createDirectory(String directory){
        new File(directory).mkdir();
    }
}
