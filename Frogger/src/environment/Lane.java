package environment;

import util.Case;
import gameCommons.Game;
import java.util.ArrayList;

public class Lane {
	protected Game game;
	protected int ord;
	protected int speed;
	protected boolean leftToRight;
	protected double density;
	protected ArrayList<Car> cars = new ArrayList<>();
	protected ArrayList<Trap> traps = new ArrayList<>();

	public Lane(gameCommons.Game game, int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 3;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
	}

	public Lane(gameCommons.Game game, int ord) { 
		this(game, ord, game.density);
		generateTrap();
		for (int i = 0; i < 50; i++) {
			update(i);
		}
	}

//	public Lane(gameCommons.Game game, int ord, boolean roadOrRiver) {
//		this(game, ord, game.density);
//		this.roadOrRiver = roadOrRiver;
//		if (roadOrRiver) generateTrap();
//		else density = 0.4;
//		for (int i = 0; i < 50; i++) {
//			moveCars(i % speed == 0 );
//			removeOldCarsAndAddToGraphics();
//			mayAddCar();
//		}
//	}

	public void update(int timer) {
		moveCars(timer % speed == 0 );
		addTrapsToGraphics();
		removeOldCarsAndAddToGraphics();
		mayAddCar();

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	protected void moveCars(boolean b) {
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
		for (Trap trap : traps) {
			trap.moveOrd(n);
		}
	}

	private void removeOldCarsAndAddToGraphics() {
		ArrayList<Car> needDelete = new ArrayList<>();
		for (Car c : cars) {
			c.addToGraphics();
			if (!c.appearsInBounds())
				needDelete.add(c);
		}
		for (Car c : needDelete) {
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
	protected void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	public boolean isSafe(Case pos) {
		for (Car c : cars) {
			if (c.coversCase(pos)) return false;
		}
		return true;
	}

	protected Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	protected Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	@Override
	public String toString() {
		return String.valueOf(cars.size());
	}

	public int isOnTrap(Case c) {
		for (Trap trap : traps) {
			if (trap.coversCase(c)) {
				if (trap.getType() == 2) {
					traps.remove(trap);
					return 2;
				}
				return trap.getType();
			}
		}
		return -1;
	}

	private void addTrapsToGraphics(){
		for (Trap trap :
				traps) {
			trap.addToGraphics();
		}
	}

	private void generateTrap(){
		for (int i = 0; i < game.width; i++) {
			if (game.randomGen.nextDouble() < game.density) {
				traps.add(new Trap(new Case(i, ord), game, game.randomGen.nextInt(3)));
			}
		}
	}
}
