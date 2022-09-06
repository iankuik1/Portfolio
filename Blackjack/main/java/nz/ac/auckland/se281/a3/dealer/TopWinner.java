package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class TopWinner implements DealerStrategies {
	// needs to access player fields in blackjack instance
	private BlackJack game;
	private List<Player> playerList;
	private Player target;
	private int highestNetWins = 0;
	private Dealer dealer;

	/**
	 * Dealer Strategy that targets the player with the highest net wins. Will
	 * return the relevant action (HIT, HOLD) the dealer should take based on target
	 * player's score
	 * 
	 * @param game   the current game/ instance of BlackJack that will contain the
	 *               player's hands/ scores and net wins. Allows this strategy to
	 *               reference them
	 * @param dealer the current dealer. Allows access to the dealer's hand and
	 *               score and determines action the dealer needs to take
	 */
	public TopWinner(BlackJack game, Dealer dealer) {
		this.game = game;
		this.dealer = dealer;
		playerList = game.getPlayers();
	}

	/**
	 * Will select target player the dealer wishes to beat, based on their net wins.
	 * If a player has 2 or more net wins, the dealer will target them. Returns the
	 * target player of type Player.
	 * 
	 * @param game is the current instance of BlackJack, where the game is taking
	 *             place. Allows access to player instances and their hands and
	 *             scores and wins.
	 * @return target player, of type Player that the dealer will target.
	 */
	private Player targetPlayer(BlackJack game) {
		for (int i = 0; i < playerList.size(); i++) {
			// if someone has HIGHER net wins, replace highestNetWins. will not change if
			// they're equal
			if (playerList.get(i).getNetWins() > highestNetWins) {
				highestNetWins = playerList.get(i).getNetWins();
				target = playerList.get(i);
			}
		}
		return target;
	}

	@Override
	public Action decideAction(Hand hand) {
		// score to beat
		int targetScore = targetPlayer(game).getHand().getScore();
		// dealer's current score
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
