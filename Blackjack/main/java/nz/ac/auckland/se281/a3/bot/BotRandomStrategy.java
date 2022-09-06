package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class BotRandomStrategy implements BotStrategies {

	// initialize random number generator
	private Random random = new Random();
	// chooses random boolean to hit or hold
	private boolean chooseAction = random.nextBoolean();
	private int bet;

	@Override
	public Action decideAction(Hand hand) {
		// false if hit, true if hold
		if (chooseAction == false) {
			return Action.HIT;
		} else {
			return Action.HOLD;
		}

	}

	@Override
	public int makeABet() {
		// random bet amount between 1 and 100 (inclusive)
		bet = random.nextInt(100) + 1;
		return bet;
	}
}
