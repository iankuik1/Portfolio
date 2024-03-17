class Participant {
    constructor(name) {
        this.name = name;
        this.hand = [];
    }

    /*
     * Initialises participant by dealing out hand 
     */
    getCard(card) {
        this.hand.push(card);
        console.log(`${card.getRank()} of ${card.getSuit()}`);
    }

    getHandSize() {
        return this.hand.length;
    }

    getName() {
        return this.name;
    }
}
