class Cpu {
    constructor(name) {
        this.name = name;
        this.deck = Array(4).fill(1); // populate deck with 1
        this.played = Array(4);
    }

    // Return a random integer between 0 and deck length (inclusive)
    getRandomNum() {
        return Math.floor(Math.random() * this.deck.length-1);
    }

    // Random card will become a skull
    addSkull() {
        const randomIndex = this.getRandomNum();
        this.deck[randomIndex] = 0;
    }

    // Get card from deck based on inputted integer
    getCard(i) {
        return this.deck[i];
    }

    // Remove random card when a skull is drawn
    removeCard() {
        const randomIndex = this.getRandomNum();
        this.deck.splice(randomIndex, 1);
    }
}
