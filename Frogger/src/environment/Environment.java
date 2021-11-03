package environment;

import java.util.ArrayList;
import frog.Frog;
import gameCommons.Case;
import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
    private ArrayList<Lane> road;
    private Game game;

    public Environment(Game game){
        this.game=game;
        this.road= new ArrayList<Lane>();
        this.road.add(new Game, new Case(game.width, game.height));

        for(int i=1; i<game.height; i++){
            this.road.add(new Lane(game, i)); // on va supposer que le constructeur Lane à été déclaré ici et en bas
        }
        this.road.add(new Lane(game,  game.height - 1, game.height))
    }


    @Override
    public boolean isSafe(Case aCase) {
        return false;
    }

    @Override
    public boolean isWinningPosition(Case aCase) {
        return false;
    }

    @Override
    public void update() {

    }

    private ArrayList<Lane> road;
    private Game game;
}
