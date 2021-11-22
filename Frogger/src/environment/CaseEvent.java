package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;
import java.util.ArrayList;

public class CaseEvent {
    protected Case leftPosition;
    protected int length = 1;
    protected Game game;
    protected ArrayList<Color>  colors = new ArrayList<>();

    public CaseEvent(Game game, Case leftPosition) {
        this.leftPosition = leftPosition;
        this.game = game;
    }
    public void moveAbs(int n) { leftPosition = new Case(leftPosition.absc + n, leftPosition.ord); }
    public void moveOrd(int n) {
        leftPosition = new Case(leftPosition.absc, leftPosition.ord + n);
    }

    public boolean appearsInBounds(){
        //addToGraphics(); pour plus tard maybe
        return leftPosition.absc+length>=0 && leftPosition.absc<game.width;
    }

    public boolean coversCase(Case c){
        if(c.ord != leftPosition.ord){
            return false;
        }else{
            return c.absc >= leftPosition.absc && c.absc < leftPosition.absc + length;
        }
    }

    private void addToGraphics() {
        for (int i = 0; i < length; i++) {
            Color color = this.colors.get(0);
            game.getGraphic()
                    .add(new Element(leftPosition.absc + i, leftPosition.ord, color));
        }
    }

}