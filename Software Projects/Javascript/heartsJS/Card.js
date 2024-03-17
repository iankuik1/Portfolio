class Card {
    constructor(suit, rank) {
        this.suit = suit;
        this.rank = rank;
    }

    toString() {
        return `${this.rank} of ${this.suit}`;
    }
}

// Enums in JavaScript
const Suit = {
    HEARTS: 'HEARTS',
    DIAMONDS: 'DIAMONDS',
    CLUBS: 'CLUBS',
    SPADES: 'SPADES'
};

const Rank = {
    ACE: 'ACE',
    TWO: 'TWO',
    THREE: 'THREE',
    FOUR: 'FOUR',
    FIVE: 'FIVE',
    SIX: 'SIX',
    SEVEN: 'SEVEN',
    EIGHT: 'EIGHT',
    NINE: 'NINE',
    TEN: 'TEN',
    JACK: 'JACK',
    QUEEN: 'QUEEN',
    KING: 'KING'
};

const card = new Card(Suit.HEARTS, Rank.ACE);
console.log(card.toString()); // Output: ACE of HEARTS
