package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class HighestBidder implements DealerStrategies {

	private BlackJack game;
	// list containing all the players of type Player
	private List<Player> playerList;
	// Initialize highestBid as 0
	private int highestBid = 0;
	// instance variables
	// private Participant dealer;
	private Player highestPlayer;
	private Dealer dealer;

	/**
	 * Will find the highest bidding player and dealer will target them. Dealer will
	 * only care about beating them.
	 * 
	 * @param game   the current instance of BlackJack, allowing dealer to access
	 *               the bids of individual players
	 * @param dealer the current dealer, allows reference/ access to the dealer's
	 *               hand and score
	 */
	public HighestBidder(BlackJack game, Dealer dealer) {
		this.game = game;
		playerList = game.getPlayers();
		this.dealer = dealer;
	}

	/**
	 * selects target player with the highest bid for this strategy
	 * 
	 * @param game takes in current instance of BlackJack (game), to access player
	 *             instances and their bets.
	 * @return the player with the highest bid that the dealer will target.
	 */
	private Player targetPlayer(BlackJack game) {
		// find highest bid
		for (int i = 0; i < playerList.size(); i++) {
			// if there's a higher bid, then change target player
			if (playerList.get(i).getHand().getBet() > highestBid) {
				highestBid = playerList.get(i).getHand().getBet();
				highestPlayer = playerList.get(i);
			}
		}
		return highestPlayer;
	}

	@Override
	public Action decideAction(Hand hand) {

		// the score that the dealer cares about beating
		int targetScore = targetPlayer(game).getHand().getScore();
		int dealerScore = this.dealer.getHand().getScore();

		// dealer holds if target is busted
		if (targetPlayer(game).getHand().isBust() == true) {
			return Action.HOLD;
		}

		// if the target has blackjack from the start and the dealer does not
		if ((targetPlayer(game).getHand().isBlackJack() == true) && (dealer.getHand().isBlackJack() == false)) {
			// will hit if less than 17
			if (dealerScore < 17) {
				return Action.HIT;
				// target wins
			} else {
				return Action.HOLD;
				// target wins
			}
		}
		// check for tie or higher score
		if (targetScore <= dealerScore) {
			return Action.HOLD;
			// dealer wins
		}

		// if dealer is losing, it should always hit
		if (targetScore > dealerScore) {
			return Action.HIT;
		}

		return null;

	}

}
