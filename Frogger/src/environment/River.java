package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;

public class River extends Lane{

    public River(Game game, int ord) {
        super(game, ord, 0.1);
    }

    @Override
    public void update(int timer) {
        addRiverToGraphics();
        super.update(timer);
    }

    private void addRiverToGraphics(){
            Color color = new Color(13, 121, 219);
            for (int i = 0; i < game.width; i++) {
                game.getGraphic()
                        .add(new Element(i, ord, color));
            }
    }

    @Override
    public boolean isSafe(Case pos) {
        return !super.isSafe(pos);
    }

    @Override
    protected void mayAddCar() {
        if (super.isSafe(getFirstCase()) && super.isSafe(getBeforeFirstCase())) {
            if (game.randomGen.nextDouble() < density) {
                cars.add(new Car(game, getBeforeFirstCase(), leftToRight, game.randomGen.nextInt(3)+2));
            }
        }
    }

    @Override
    protected void moveCars(boolean b) {
        super.moveCars(b);
        if (b) if (game.getOrd() == ord) game.moveSideway(leftToRight);
    }
}
