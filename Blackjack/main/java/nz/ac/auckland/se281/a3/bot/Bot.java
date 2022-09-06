package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	private String strategy;

	/**
	 * Bot class creates new instances of bots which will use the strategy that the
	 * user inputs.
	 * 
	 * @param name     String, name of bot
	 * @param strategy String, the strategy that the bots will use
	 */
	public Bot(String name, String strategy) {
		super(name);
		this.strategy = strategy;
	}

	/**
	 * Takes in the strategy that the user wishes the bots to use and returns the
	 * bot implementing that strategy. Returns the appropriate action the bot will
	 * take depending on the strategy inputted
	 * 
	 * @param strategy is the strategy that the user inputs that the bots will use
	 * @return the strategy that the bot will use/ the action that the bot will
	 *         return using this strategy
	 */
	public static BotStrategies createStrategy(String strategy) {
		// factory design for choosing strategy for each bot, based on input
		switch (strategy) {
		// if user types LR, use low risk strategy
		case "LR":
			return new BotLowRisk();
		// if user types HR, use high risk strategy
		case "HR":
			return new BotHighRisk();
		// if user types R, use random strategy
		case "R":
			return new BotRandomStrategy();
		// if the user doesn't type any of these, return "invalid strategy"
		default:
			System.out.println("invalid strategy");
		}
		return null;
	}

	// methods to be overwritten differently depending on strategy
	@Override
	public Action decideAction(Hand hand) {
		// returns the action for the appropriate strategy
		return createStrategy(strategy).decideAction(hand);
	}

	@Override
	public int makeABet() {
		return createStrategy(strategy).makeABet();
	}
}
