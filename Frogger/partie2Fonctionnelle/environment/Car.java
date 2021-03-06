package environment;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

import java.awt.*;

public class Car {
	private Game game;
	private Case leftPosition;
	private final boolean leftToRight;
	private final int length = 2;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	public Car(Game game, Case leftPosition, boolean leftToRight/*, int length*/){
		this.game= game;
		this.leftPosition=leftPosition;
		this.leftToRight=leftToRight;
//		this.length=length;
	}
	
	public void moveAbs(){
		leftPosition = new Case(leftPosition.absc + (leftToRight ? 1 : (-1)), leftPosition.ord);/* si la voiture va vers la droite la vitesse est positive et négative dans l'autre cas */
	}

	public void moveOrd(int n) {
		leftPosition = new Case(leftPosition.absc, leftPosition.ord + n);
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
