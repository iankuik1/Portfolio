package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class BotHighRisk implements BotStrategies {

	private int bet;
	// new random number generator
	private Random random = new Random();

	@Override
	// decide action is passed the hand of the bot to check score
	public Action decideAction(Hand hand) {
		// hold if score >= 19, otherwise hit
		if (hand.getScore() >= 19) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	@Override
	public int makeABet() {
		// makes a bet between 50 and 100 inclusive.
		// nextInt(n) returns 0 <= int < n
		bet = random.nextInt(51) + 50;
		return bet;
	}

}
