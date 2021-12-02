package graphicalElements;

import util.Case;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Element extends Case {
    public final Color color;
    public BufferedImage sprite;

    public Element(int absc, int ord, Color color) {
        super(absc, ord);
        this.color = color;
    }
    
    public Element(Case c, Color color) {
        super(c.absc, c.ord);
        this.color = color;
    }

    public Element(int absc, int ord, Color color, BufferedImage sprite){
        this(absc, ord, color);
        this.sprite = sprite;
    }
}
