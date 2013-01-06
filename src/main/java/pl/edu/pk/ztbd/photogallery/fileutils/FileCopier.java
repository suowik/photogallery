package pl.edu.pk.ztbd.photogallery.fileutils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 06.01.13
 * Time: 11:45
 */
public class FileCopier {
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        IOUtils.copy(inputStream,outputStream);
    }
}
