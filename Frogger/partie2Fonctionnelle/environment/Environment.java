package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment implements IEnvironment {
    private ArrayList<Lane> road;
    private Game game;
    private int timer;

    public Environment(Game game){
        this.game=game;
        this.road= new ArrayList<Lane>();
        this.road.add(new Lane(game, 0, 0));
        for(int i=1; i<game.height-1; i++){
            this.road.add(new Lane(game, i));
        }
        this.road.add(new Lane(game,  game.height - 1, 0));
        this.timer=0;
        for (int i = 0; i < 20; i++) {
            update();
        }
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
}
