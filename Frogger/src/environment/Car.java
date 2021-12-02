package environment;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

import java.awt.*;

public class Car extends CaseEvent {
	private final boolean leftToRight;

	public Car(Game game, Case leftPosition, boolean leftToRight){
		super(game, leftPosition);
		this.leftToRight = leftToRight;
		this.length = 2;
		this.colors.add(Color.RED);
		this.colors.add(Color.BLUE);
	}
	
	public void moveAbs(){
		leftPosition = new Case(leftPosition.absc + (leftToRight ? 1 : (-1)), leftPosition.ord);
	}

	public boolean appearsInBoundsAndAddToGraphics(){
		addToGraphics();
		return leftPosition.absc+length>=0 && leftPosition.absc<game.width; // Confusion entre && et ||
	}

		/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	public void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colors.get(leftToRight? 1 : 0);
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
