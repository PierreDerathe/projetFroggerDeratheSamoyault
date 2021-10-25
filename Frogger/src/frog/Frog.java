package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

import javax.swing.text.Position;

public class Frog implements IFrog {
	
	private Game game;
	private Case position;
	private Direction direction;


	@Override
	public Case getPosition(){
		return position;
	}

	@Override
	public Direction getDirection(){
		return direction;
	}

	@Override
	public void move(Direction key){
		position = key == Direction.up? new Case(position.absc, position.ord+1) :
				key == Direction.down? new Case(position.absc, position.ord-1) :
						key == Direction.left? new Case(position.absc-1, position.ord) :
								new Case(position.absc+1, position.ord);
	}


}
