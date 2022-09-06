package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * This interface overwrites/ determines behavior of the dealer based on the
 * strategy that it is currently using.
 * 
 * @author iankuik
 *
 */
public interface DealerStrategies {
	/**
	 * Will determine the action that the dealer will take
	 * 
	 * @param hand this is the dealer's current hand
	 * @return the action the dealer will take ie HIT or HOLD
	 */
	Action decideAction(Hand hand);
}
