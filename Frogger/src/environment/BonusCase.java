package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;
import java.util.ArrayList;

public class BonusCase extends CaseEvent{
    private final ArrayList<Color> color = new ArrayList<>();

    public BonusCase(Case leftPosition, Game game, Element elem) {

        super(game, leftPosition);
        color.add(Color.RED);
        color.add(Color.CYAN);
        color.add(Color.ORANGE);
    }

}
