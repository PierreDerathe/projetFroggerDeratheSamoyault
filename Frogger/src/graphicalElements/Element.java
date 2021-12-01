package graphicalElements;

import util.Case;

import java.awt.*;


public class Element extends Case {
    public final Color color;
    //public final BufferedImage sprite;

    public Element(int absc, int ord, Color color) {
        super(absc, ord);
        this.color = color;
        //this.sprite=sprite;
    }
    
    public Element(Case c, Color color) {
        super(c.absc, c.ord);
        this.color = color;
        //this.sprite=sprite;
    }
}
