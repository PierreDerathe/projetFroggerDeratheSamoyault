package environment;

import util.Case;
import gameCommons.Game;

import java.util.ArrayList;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private int timer;

	public Lane(gameCommons.Game game, int ord, double density) { /* compiled code */ }

	public Lane(gameCommons.Game game, int ord) { /* compiled code */ }

	public void update() {

		timer++;
		moveCars(timer % speed == 0 );
		removeOldCars();
		mayAddCar();
		}

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	// TODO : ajout de methodes

	private void moveCars(boolean b) {
		if (b) for (Car car :
				cars) {
			car.move();
		}
	}

	private void removeOldCars() {
		while (!cars.get(0).appearsInBounds()) cars.remove(0);
	}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight, 2));
			}
		}
	}

	public boolean isSafe(util.Case pos) {
		return cars.get(cars.size()-1).coversCase(pos);
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

	public java.lang.String toString() { /* compiled code */ }

}
