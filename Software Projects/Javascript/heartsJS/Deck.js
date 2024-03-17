class Deck {
    constructor() {
        this.cards = [];
        this.initializeDeck(); // initialize deck
        this.shuffle(); // shuffle
    }

    initializeDeck() {
        const { Suit, Rank } = Card;
        for (const suit in Suit) {
            for (const rank in Rank) {
                this.cards.push(new Card(Suit[suit], Rank[rank]));
            }
        }
    }

    shuffle() {
        // Fisher-Yates shuffle algorithm
        for (let i = this.cards.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [this.cards[i], this.cards[j]] = [this.cards[j], this.cards[i]];
        }
    }

    size() {
        return this.cards.length;
    }

    dealCard() {
        if (this.cards.length === 0) {
            throw new Error("Deck is empty");
        }
        return this.cards.shift();
    }
}
