package environment;

import util.Position;
import gameCommons.Game;

import java.util.ArrayList;

public class Lane {
	private Game game;
	private Integer ord;
	private final int speed;
	private final boolean leftToRight;
	private final double density;
	private ArrayList<Car> cars = new ArrayList<>();

	public Lane(gameCommons.Game game, int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
	}

	public Lane(gameCommons.Game game, int ord) { this(game, ord, game.defaultDensity); }

	public Lane(gameCommons.Game game, int ord, int nbUpdate){
		this(game, ord);
		for (int i = 0; i < nbUpdate; i++) {
			this.update(i);
		}
	}

	public Lane(Game game){
		this(game, 0, 40);
		ord = null;
	}

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

	public void setOrd(int ord) {
		this.ord = Integer.valueOf(ord);
	}

	private void moveCars(boolean b) {
		if (b) for (Car car :
				cars) {
			car.move();
		}
	}

	private void removeOldCars() {
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
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight/*, game.randomGen.nextInt(2)+1*/));
			}
		}
	}

	public boolean isSafe(util.Position pos) {
		for (Car c :
				cars) {
			if (c.coversCase(pos)) return false;
		}
		return true;
	}

	private Position getFirstCase() {
		if (leftToRight) {
			return new Position(0, ord);
		} else
			return new Position(game.width - 1, ord);
	}

	private Position getBeforeFirstCase() {
		if (leftToRight)
			return new Position(-1, ord);
		else
			return new Position(game.width, ord);
	}

	@Override
	public String toString() {
		return String.valueOf(cars.size());
	}
}
