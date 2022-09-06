package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * Interface for Bot Strategies. Describes and overwrites behaviours of the
 * decideAction() and makeABet() methods of each bot. These are the only two
 * methods that will be changed according to the strategy inputted.
 * 
 * @author iankuik
 *
 */
public interface BotStrategies {
	/**
	 * Will decide the action that the bot will take, to be implemented in strategy
	 * class
	 * 
	 * @param hand is the current hand of the bot, will be used to determine whether
	 *             to hold or hit
	 * @return the action the bot will take; HIT or HOLD
	 */
	Action decideAction(Hand hand);

	/**
	 * will make a bet for a bot; to be implemented in relevant strategy class
	 * 
	 * @return an integer which is the total bet that the bot will make
	 */
	int makeABet();
}
