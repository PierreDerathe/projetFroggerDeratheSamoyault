package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment implements IEnvironment {
    private ArrayList<Lane> road;
    private Game game;
    public int timer = 0;

    public Environment(Game game){
        this.game=game;
        this.road= new ArrayList<>();
        this.road.add(new Lane(game, 0, 0));
        for(int i=1; i<game.height-1; i++){
            this.road.add(new Lane(game, i));
        }
        this.road.add(new Lane(game,  game.height - 1, 0));
    }


    @Override
    public boolean isSafe(Case c) {
       return road.get(c.ord).isSafe(c);
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == game.height-1;
    }

    @Override
    public void update() {
        timer++;
        for (Lane l: road ){
            l.update(timer);
        }
    }

    @Override
    public void shiftForward() {
        boolean tmp;
        if (game.randomGen.nextDouble() < 0.9) {
            tmp = road.get(road.size() - 1) instanceof River;
        } else {
            tmp = !(road.get(road.size() - 1) instanceof River);
        }
        road.remove(0);
        if (tmp) road.add(new River(game, game.height));
        else road.add(new Lane(game, game.height));
        for (Lane l :
                road) {
            l.moveOrd(-1);
        }
    }

    @Override
    public int getTimer() {
        return timer;
    }

    public int isOnTrap(Case c){
        return road.get(c.ord).isOnTrap(c);
    }
}
