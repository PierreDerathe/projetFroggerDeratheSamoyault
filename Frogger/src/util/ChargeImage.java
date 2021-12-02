package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;

public class ChargeImage {
    private HashMap<String, Image> loadImg = new HashMap<>();

    public Image getImage(String name) {
        if (!loadImg.containsKey(name)) {
            URL loadNewImage = getClass().getResource("ImageJPG" + name + ".jpg");
            try {
                loadImg.put(name, ImageIO.read(loadNewImage));
            } catch (java.io.IOException excep) {
                System.out.println("Aucune image recherché n'existe, try again");
                Runtime.getRuntime().exit(1);
            }
        }
        return loadImg.get(name);
    }
}
