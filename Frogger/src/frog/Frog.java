package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Position;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Position position;
	private Direction direction;

	public Frog(Game game){
		this.game = game;
		this.position = new Position(game.width/2, 0);
		this.direction = Direction.up;
	}

	@Override
	public Position getPosition(){
		return position;
	}

	@Override
	public Direction getDirection(){
		return direction;
	}

	@Override
	public void move(Direction key){
		Position pos = key == Direction.up? new Position(position.absc, position.ord+1) :
				key == Direction.down? new Position(position.absc, position.ord-1) :
						key == Direction.left? new Position(position.absc-1, position.ord) :
								new Position(position.absc+1, position.ord);
		if (pos.absc < game.width && pos.absc >= 0 && pos.ord < game.height && pos.ord >= 0) {
			position = pos;
			direction = key;
		}
	}

}
