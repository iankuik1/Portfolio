package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class BotLowRisk implements BotStrategies {
	// generate new random number generator
	private Random random = new Random();
	private int bet;

	@Override
	public Action decideAction(Hand hand) {
		// hold if score >= 17, otherwise hit
		if (hand.getScore() >= 17) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	@Override
	public int makeABet() {
		// make a bet between 0 and 50 inclusive
		bet = random.nextInt(41) + 10;
		return bet;
	}

}
