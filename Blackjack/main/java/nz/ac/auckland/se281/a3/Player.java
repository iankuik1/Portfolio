package nz.ac.auckland.se281.a3;

public abstract class Player extends Participant {
	// every player will have a number of wins, initially at 0
	protected int wins = 0;
	protected int losses = 0;
	protected String outcome;

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

	public int getNetWins() {
		return wins - losses;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public String getOutcome() {
		return outcome;
	}
}
