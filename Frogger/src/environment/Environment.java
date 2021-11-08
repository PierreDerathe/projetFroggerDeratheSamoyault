package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment implements IEnvironment {
    private ArrayList<Lane> road;
    private Game game;

    public Environment(Game game){
        this.game=game;
        this.road= new ArrayList<Lane>();
        this.road.add(new Lane(game, 0, 0));
        for(int i=1; i<game.height-1; i++){
            this.road.add(new Lane(game, i)); // on va supposer que le constructeur Lane à été déclaré ici et en bas
        }
        this.road.add(new Lane(game,  game.height - 1, 0));
    }


    @Override
    public boolean isSafe(Case aCase) {
       return road.get(aCase.ord).isSafe(aCase);
    }

    @Override
    public boolean isWinningPosition(Case aCase) {
        return aCase.ord == game.height-1;
    }

    @Override
    public void update() {
        for (Lane parLigne: road ){
            parLigne.update();
        }
    }
}
