package environment;

import util.Case;
import gameCommons.Game;
import graphicalElements.Element;

import java.awt.*;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	public Car(Game game, Case leftPosition, boolean leftToRight, int length, Color colorLtR, Color colorRtL){
		this.game= game;
		this.leftPosition=leftPosition;
		this.leftToRight=leftToRight;
		this.length=length;
		this.colorLtR= colorLtR;
		this.colorRtL=colorRtL;
	}
	
	public void update(int speed){
		if(!leftToRight){
			speed = -speed; /* si la voiture va vers la droite la vitesse est positive et négative dans l'autre cas */
		}
	}

	public boolean appearsInBounds(){
		return this.leftPosition.absc+this.length>0 || this.leftPosition.absc<this.game.width;
	}
	public boolean isOnCase(Case c){
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

}
