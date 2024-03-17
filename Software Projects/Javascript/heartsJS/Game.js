class Game {
    static main() {
        const deck = new Deck(); // create deck
        
        const cpu1 = new Participant("cpu1");
        const cpu2 = new Participant("cpu2");
        const cpu3 = new Participant("cpu3");
        const p1 = new Player("Player");
        
        // deal cards
        for (let i = 0; i < 13; i++) {
            cpu1.getCard(deck.dealCard());
            cpu2.getCard(deck.dealCard());
            cpu3.getCard(deck.dealCard());
            p1.getCard(deck.dealCard());
        }
    }
}
