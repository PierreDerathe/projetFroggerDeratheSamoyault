package gameCommons;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import util.Direction;

public class Game {

	public final Random randomGen = new Random();

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;

	// Lien aux objets utilis�s
	private IEnvironment environment;
	private IFrog frog;
	private IFroggerGraphics graphic;

	//Condition de victoire
	private Integer score = 0;
	private String tempsDeJeu;
	private ArrayList<Integer> tabScore = new ArrayList<>();
	private int relaunch = 0;

	/**
	 * 
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de tempsDeJeu avant d�placement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public Game(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;
	}

	/**
	 * Lie l'objet frog � la partie
	 * 
	 * @param frog la grenouille jouée
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	/**
	 * Lie l'objet environment a la partie
	 * 
	 * @param environment de jeu
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 * 
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
	 * est le cas
	 * 
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		return !environment.isSafe(frog.getPosition());
	}

	public void testTrap() {
		switch (environment.isOnTrap(frog.getPosition())) {
			case 0 : endGame(); break;
			case 1 : frog.move(Direction.up); break;
			case 2 : score += 3;
		}
	}

	public void ShiftForward() {
		frog.move(Direction.down);
		environment.shiftForward();
		score++;
	}

	/**
	 * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
	 * est le cas
	 * 
	 * @return true si la partie est gagn�e
	 */
	public boolean testWin() {
		return environment.isWinningPosition(frog.getPosition());
	}

	public String getTempsDeJeu() { return tempsDeJeu; }

	public void endGame() {
		tempsDeJeu = String.valueOf(environment.getTimer());
		graphic.endGameScreen("Score : " + score + " Temps : " + tempsDeJeu);
	}

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		if (tempsDeJeu == null) {
			graphic.clear();
			environment.update();
			this.graphic.add(new Element(frog.getPosition(), Color.GREEN));
			if (testLose()) {
				endGame();
			}
		}
	}

	public void launchReset() { tempsDeJeu = "C'est repartie";}

	public void reset() {
		tempsDeJeu = null;
		tabScore.add(score);
		System.out.println(score);
		score = 0;

	}

}
