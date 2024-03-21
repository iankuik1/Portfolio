const score1 = document.getElementById("score1");
const score2 = document.getElementById('score2');
const score3 = document.getElementById('score3');
let curValue1 = -1;
let curValue2 = -1;
let curValue3 = -1;

const incrementScore = (scoreElement, scoreValue) => {
  scoreValue++;
  scoreElement.textContent = scoreValue;
};

const keysPressed = {};

document.addEventListener('keydown', (event) => {
  if (!keysPressed[event.key]) {
    keysPressed[event.key] = true;
    if (event.key === '1') {
      incrementScore(score1, ++curValue1);
    } else if (event.key === '2') {
      incrementScore(score2, ++curValue2);
    } else if (event.key === '3') {
      incrementScore(score3, ++curValue3);
    }
  }
});

document.addEventListener('keyup', (event) => {
  keysPressed[event.key] = false;
});
