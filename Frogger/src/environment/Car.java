package environment;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

import java.awt.*;
import java.util.Random;

public class Car {
	private Game game;
	private Case leftPosition;
	private final boolean leftToRight;
	private final int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	public Car(Game game, Case leftPosition, boolean leftToRight, int length){
		this.game= game;
		this.leftPosition=leftPosition;
		this.leftToRight=leftToRight;
		this.length = getRandomNumberInRange(1, 3);
	}
	
	public void move(){
		leftPosition = new Case(leftPosition.absc+(leftToRight?1:(-1)), leftPosition.ord);/* si la voiture va vers la droite la vitesse est positive et négative dans l'autre cas */
	}

	public boolean appearsInBounds(){
		return this.leftPosition.absc+this.length>0 || this.leftPosition.absc<this.game.width;
	}

	public boolean coversCase(Case c){
		if(c.ord != this.leftPosition.ord){
			return false;
		}else{
			return c.absc >= this.leftPosition.absc && c.absc < this.leftPosition.absc + this.length;
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

	private static int getRandomNumberInRange(int min, int max) {

		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

	}

}
