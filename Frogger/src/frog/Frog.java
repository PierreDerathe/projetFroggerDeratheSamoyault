package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frog implements IFrog {
	
	private Game game;
	private Case position;
	private Direction direction;
	//création du sprite pour la grenouille
	private BufferedImage sprite = null;

	public Frog(Game game){
		this.game = game;
		this.position = new Case(game.width/2, 0);
		this.direction = Direction.up;
		//sprite pour la grenouille
		try {
			this.sprite = ImageIO.read(new File("ImagesJPG/froger.png.jpg"));
		} catch (IOException ioException) {
			System.out.println(ioException);
		}
	}


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
		Case pos = key == Direction.up? new Case(position.absc, position.ord+1) :
				key == Direction.down? new Case(position.absc, position.ord-1) :
						key == Direction.left? new Case(position.absc-1, position.ord) :
								new Case(position.absc+1, position.ord);
		if (pos.absc < game.width && pos.absc >= 0 && pos.ord < game.height && pos.ord >= 0) {
			position = pos;
			direction = key;
		}
		if (position.ord > game.height/3) game.ShiftForward();
	}

	public void launchReset() { game.reset(); }

}
