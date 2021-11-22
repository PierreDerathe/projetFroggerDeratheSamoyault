package environment;

import util.Case;
import gameCommons.Game;

import java.util.ArrayList;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private boolean leftToRight;
	private double density;
	private ArrayList<Car> cars = new ArrayList<>();
	private ArrayList<Trap>listPiege;

	public Lane(gameCommons.Game game, int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 2;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
		for (int i = 0; i < 40; i++) {
			update(i);
		}
	}

	public Lane(gameCommons.Game game, int ord) { this(game, ord, game.defaultDensity); }

	public void update(int timer) {
		moveCars(timer % speed == 0 );
		removeOldCars();
		mayAddCar();

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	private void moveCars(boolean b) {
		if (b) for (Car car :
				cars) {
			car.moveAbs();
		}
	}
	
	public void moveOrd(int n) {
		ord += n;
		for (Car c : cars) {
			c.moveOrd(n);
		}
	}

	private void removeOldCars() {
//		if(!cars.isEmpty())
//			while (!cars.get(0).appearsInBounds())
//				cars.remove(0);
		ArrayList<Car> needDelete = new ArrayList<>();
		for (Car c :
				cars) {
			if (!c.appearsInBounds())
				needDelete.add(c);
		}
		for (Car c :
				needDelete) {
			cars.remove(c);
		}
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
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	public boolean isSafe(util.Case pos) {
		for (Car c :
				cars) {
			if (c.coversCase(pos)) return false;
		}
		return true;
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

	@Override
	public String toString() {
		return String.valueOf(cars.size());
	}


	public int isOnTrap(Case c) {
		for (Trap trap : listPiege) {
			if (trap.coversCase(c)) {
				return trap.getType();
			}
		}
		return -1;
	}
}
