package environment;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

import java.awt.*;

public class Car extends CaseEvent {
	private final boolean leftToRight;
	private final Color colorLtR = Color.red;
	private final Color colorRtL = Color.BLUE;

	public Car(Game game, Case leftPosition, boolean leftToRight){
		super(game, leftPosition);
		this.leftToRight=leftToRight;
		this.length = 2;
	}
	
	public void moveAbs(){
		leftPosition = new Case(leftPosition.absc + (leftToRight ? 1 : (-1)), leftPosition.ord);
	}

	public boolean appearsInBounds(){
		addToGraphics();
		return leftPosition.absc+length>=0 && leftPosition.absc<game.width; // Confusion entre && et ||
	}

	public boolean coversCase(Case c){
		if(c.ord != leftPosition.ord){
			return false;
		}else{
			return c.absc >= leftPosition.absc && c.absc < leftPosition.absc + length;
		}
	}

		/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
