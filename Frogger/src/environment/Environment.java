package environment;

import java.awt.*;
import java.util.ArrayList;

import frog.Frog;
import util.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
		private Game game;
		private Case c;
		private Frog frog;
		private ArrayList<Lane > lane= new ArrayList<>(); //A conserver ou non
        private Car car;
        private final Color colorLtR = Color.BLACK;
        private final Color colorRtL = Color.BLUE;

        public Environment(Game game,Frog frog, Case c ,ArrayList<Lane > lane, Car car, Color colorLtR, Color colorRtL){
            this.game = game;
            this.c=c;
            this.frog=frog;
            this.car=car;
            this.colorRtL=colorRtL;
            this.colorLtR=colorLtR;

        }


}
