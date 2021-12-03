package environment;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

import java.awt.*;

public class Car extends CaseEvent {
	private final boolean leftToRight;
	private boolean onGround = true;

	public Car(Game game, Case leftPosition, boolean leftToRight){
		super(game, leftPosition);
		this.leftToRight = leftToRight;
		this.length = 2;
		this.colors.add(Color.RED);
		this.colors.add(Color.BLUE);
		this.colors.add(new Color(139,69,19));
	}

	public Car(Game game, Case leftPosition, boolean leftToRight, int length){
		this(game, leftPosition, leftToRight);
		this.onGround = false;
		this.length = length;
	}

	public void moveAbs(){
		leftPosition = new Case(leftPosition.absc + (leftToRight ? 1 : (-1)), leftPosition.ord);
	}

		/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	public void addToGraphics() {
		Color color = colors.get(onGround? leftToRight? 1 : 0 : 2);
		for (int i = 0; i < length; i++) {
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
