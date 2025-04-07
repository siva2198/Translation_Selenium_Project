package Util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * Author: Sivaraman M
 * User:Sivaraman M
 */
public class ImageDownloader {
    public static void downloadImage(String imageUrl, String fileName) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage img = ImageIO.read(url);
            ImageIO.write(img, "jpg", new File("images/" + fileName + ".jpg"));
            System.out.println("Image downloaded: " + fileName);
        } catch (Exception e) {
            System.out.println("Image download failed: " + e.getMessage());
        }
    }
}
