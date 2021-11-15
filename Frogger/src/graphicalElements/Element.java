package graphicalElements;

import java.awt.*;

import util.Position;


public class Element extends Position {
    public final Color color;

    public Element(int absc, int ord, Color color) {
        super(absc, ord);
        this.color = color;
    }
    
    public Element(Position c, Color color) {
        super(c.absc, c.ord);
        this.color = color;
    }
    
}
