package designandpatternTest;

/**
 * This class is written for the example to illustrate the interface and the
 * innerclass, and how to use the Factory pattern, and it may reveal why the
 * parcelable in the android must have a CREATOR static field
 * 
 * @author bdgong
 * 
 */

interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

class Checkers implements Game {

	private Checkers() {
	}

	private int moves = 0;
	private static final int MOVES = 3;

	public boolean move() {
		System.out.println("Checkers move " + moves);
		return ++moves != MOVES;
	}

	public static final GameFactory FACTORY = new GameFactory() {

		public Game getGame() {
			return new Checkers();
		}
	};
}

class Chess implements Game {
	private Chess() {
	}

	private int moves = 0;
	private static final int MOVES = 4;

	public boolean move() {
		System.out.println("Chess move " + moves);
		return ++moves != MOVES;
	}

	public static final GameFactory FACTORY = new GameFactory() {

		public Game getGame() {
			return new Chess();
		}
	};

}

public class InnerClassForFactory {


	static void playGame(GameFactory factory) {
		Game s = factory.getGame();
		while (s.move());
	}

	public static void main(String[] args) {
		playGame(Checkers.FACTORY);
		playGame(Chess.FACTORY);
	}
}
