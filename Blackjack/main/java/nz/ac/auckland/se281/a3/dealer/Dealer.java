package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;

public class Dealer extends Participant {

	private BlackJack game;

	/**
	 * Dealer class, defines the dealer behaviours which will be implemeneted using
	 * dealer strategy interface as behaviours are different according to strategy
	 * used
	 * 
	 * @param game the current instance of BlackJack, allows access to the hands of
	 *             the players, their scores and net wins. Allows dealer to choose
	 *             the appropriate strategy
	 * @param name the name of the dealer
	 */
	public Dealer(BlackJack game, String name) {
		super(name);
		this.game = game;
	}

	@Override
	public Action decideAction(Hand hand) {
		// if a player has < 2 net wins, use highestBidder
		if (game.getHighestNetWins() < 2) {
			// pass in current game instance and the dealer
			return new HighestBidder(game, this).decideAction(hand);
		} else {
			// use topWinner if they have >= 2 net wins
			// pass in game instance and dealer
			return new TopWinner(game, this).decideAction(hand);
		}
	}
}
