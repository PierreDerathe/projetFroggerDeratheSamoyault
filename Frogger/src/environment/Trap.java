package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;
import java.util.ArrayList;

public class Trap extends CaseEvent{
    private int type; // 0 est mortel, 1 est glissant, 2 est bonus
    private final ArrayList<Color> color = new ArrayList<>();

    public Trap(Case leftPosition, Game game, int type){
        super(game, leftPosition);
        this.type = type;
        color.add(Color.RED);
        color.add(Color.CYAN);
        color.add(Color.ORANGE);
    }


    public int getType() {
        return type;
    }

    private void addToGraphics() {
        for (int i = 0; i < length; i++) {
            Color color = this.color.get(type);
            game.getGraphic()
                    .add(new Element(leftPosition.absc + i, leftPosition.ord, color));
        }
    }
}
