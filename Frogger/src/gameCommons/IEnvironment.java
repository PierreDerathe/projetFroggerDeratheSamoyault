package gameCommons;

import util.Position;

public interface IEnvironment {

	/**
	 * Teste si une case est sure, c'est � dire que la grenouille peut s'y poser
	 * sans mourir
	 * 
	 * @param c
	 *            la case � tester
	 * @return vrai s'il n'y a pas danger
	 */
	public boolean isSafe(Position c);

	/**
	 * Teste si la case est une case d'arrivee
	 * 
	 * @param c
	 * @return vrai si la case est une case de victoire
	 */
	public boolean isWinningPosition(Position c);

	/**
	 * Effectue une �tape d'actualisation de l'environnement
	 */
	public void update();

	/**
	 * @return Le nombre d'update depuis le début d'une partie
	 */
	public int getTimer();

	/**
	 * @param n Le nombre de décalage
	 * Décale l'environnement de n ligne vers le haut
	 * et incrémente le décalage total de n
	 */
	public void shiftForward(int n);

}
