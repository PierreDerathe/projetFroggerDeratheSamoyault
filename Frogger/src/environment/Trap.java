package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

public class Trap extends CaseEvent{

    public Trap(Case leftPosition, Game game, Element elem) {
        super(game, leftPosition);
    }

    public void caseBonus(Case c){

    }
}
