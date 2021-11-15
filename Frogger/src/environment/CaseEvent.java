package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

public class CaseEvent {
    protected Case leftPosition;
    protected int length = 1;
    protected Game game;

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

}