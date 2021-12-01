package gameCommons;

import util.Case;
import util.Direction;

public interface IFrog {
	
	/**
	 * Donne la position actuelle de la grenouille
	 * @return la position actuelle de la grenouille
	 */
	Case getPosition();
	
	/**
	 * Donne la direction de la grenouille, c'est � dire de son dernier mouvement 
	 * @return direction de la grenouille
	 */
	Direction getDirection();
	
	/**
	 * D�place la grenouille dans la direction donn�e et teste la fin de partie
	 * @param key la direction de déplacement
	 */
	void move(Direction key);

	void launchReset();
}
