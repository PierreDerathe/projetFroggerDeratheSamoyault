package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

public class CaseEvent {
    private Case leftPosition;
    private final int length =1;
    private Game game;
    private Element elem;

    public CaseEvent(Case leftPosition, Game game, Element elem) {
        this.leftPosition = leftPosition;
        this.game = game;
        this.elem = elem;
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

}