package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.dealer.Dealer;

public class BlackJack {

	private List<Player> players;
	private Dealer dealer;
	private Deck deck;
	protected BlackJack game = this;
	private int highestNetWins = 0;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * This constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	protected void initBots() {
		String botStrategyString = getBotStrategy();
		// factory design pattern, but for strategies
		Bot bot1 = new Bot("Bot1", botStrategyString);
		Bot bot2 = new Bot("Bot2", botStrategyString);

		// create and set Bots strategy here
		players.add(bot1);
		players.add(bot2);
	}

	protected void initDealer() {
		// intialize dealer, pass this BlackJack instance through
		dealer = new Dealer(game, "Dealer");
	}

	/**
	 * will check through player instances and determine a winner based on
	 * everyone's hands and score updates results and outcomes. Void method does not
	 * return anything, just changes the wins/ losses variables for each player
	 * 
	 * @param game is the current instance of the game to access each player
	 *             instance
	 */
	private void winCheck(BlackJack game) {
		boolean dealerBlackjack = dealer.getHand().isBlackJack();
		// if dealer has blackjack, dealer wins and all players lose
		if (dealerBlackjack == true) {
			for (int i = 0; i < players.size(); i++) {
				players.get(i).losses++;
				players.get(i).outcome = "lost";
			}
		}
		// if the dealer is bust
		if (dealer.getHand().isBust() == true) {
			for (int i = 0; i < players.size(); i++) {
				// if the dealer is bust, and the players aren't, they all win
				if (players.get(i).getHand().isBust() == false) {
					players.get(i).wins++;
					players.get(i).outcome = "won";
				} else {
					// if bust, they lose
					players.get(i).losses++;
					players.get(i).outcome = "lost";
				}
			}
		}
		// if the dealer has no blackjack and doesn't bust, check who wins and loses
		if (dealerBlackjack == false && dealer.getHand().isBust() == false) {
			for (int i = 0; i < players.size(); i++) {
				// if blackjack, or they score 21 they win
				if (players.get(i).getHand().isBlackJack() == true || players.get(i).getHand().is21() == true) {
					players.get(i).wins++;
					players.get(i).outcome = "won";
				} else {
					// if the player's hand beats the dealer and they don't bust, they win
					if ((players.get(i).getHand().getScore() > dealer.getHand().getScore())
							&& (players.get(i).getHand().isBust() == false)) {
						players.get(i).wins++;
						players.get(i).outcome = "won";
					} else {
						// if player loses to dealer either from bust or less points, update results
						players.get(i).losses++;
						players.get(i).outcome = "lost";
					}
				}
			}
		}
	}

	/**
	 * checks for the highest net win of all players. used to switch to TopWinner
	 * strategy for the dealer
	 * 
	 * @return the highest net win of all players
	 */
	public int getHighestNetWins() {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getNetWins() > highestNetWins) {
				highestNetWins = players.get(i).getNetWins();
			}
		}
		return highestNetWins;
	}

	/**
	 * updates the wins and losses for each player from every round and will print
	 * the results
	 * 
	 * @param round the current round number for printing purposes
	 */
	protected void printAndUpdateResults(int round) {
		// check for a win
		winCheck(game);
		// print winnings and losses for each player
		for (int i = 0; i < players.size(); i++) {
			// Round (int Round): name won/lost bet() chips
			System.out.println("Round " + round + ": " + players.get(i).getName() + " " + players.get(i).getOutcome()
					+ " " + players.get(i).getHand().getBet() + " chips");
		}
	}

	protected void printGameStatistics() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + " won " + players.get(i).getWins() + " times and lost "
					+ players.get(i).getLosses() + " times");
		}
	}

}