document.addEventListener('DOMContentLoaded', () => {
  const score1 = document.getElementById("score1");
  const score2 = document.getElementById('score2');
  const score3 = document.getElementById('score3');
  const timer = document.getElementById('timeReading')
  // Function to format time in mm:ss format
  const formatTime = (minutes, seconds) => {
    return `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
  };

  // Function to update timer display
  const updateTimer = (minutes, seconds) => {
    timer.textContent = formatTime(minutes, seconds);
  };

  // Function to start countdown timer
  const startTimer = () => {
    console.log();
    let totalSeconds = 3 * 60; // 3 minutes in seconds
    const countdown = setInterval(() => {
      const minutes = Math.floor(totalSeconds / 60);
      const seconds = totalSeconds % 60;
      updateTimer(minutes, seconds);
      totalSeconds--; // Decrement totalSeconds here
      if (totalSeconds < 0) {
        clearInterval(countdown);
        timer.textContent = "00:00"; // Optionally set text when timer reaches 0
        // play sound
      }
    }, 1000); // Update timer every second
  };

  // sounds
  //const cashRegister = new Audio(CashRegister.mp3);

  // Call the startTimer function to begin the countdown
  startTimer();
  
  let curValue1 = -1;
  let curValue2 = -1;
  let curValue3 = -1;

  const incrementScore = (scoreElement, scoreValue) => {
    scoreValue++;
    if(scoreValue < 10) {
      scoreElement.textContent = "0" + scoreValue; // add 0 for padding and consistency
    } else {
      scoreElement.textContent = scoreValue; // otherwise update score as normal
    }
  
  };

  const keysPressed = {};

  document.addEventListener('keydown', (event) => {
    if (!keysPressed[event.key]) {
      keysPressed[event.key] = true;
      if (event.key === '1') {
        // press 1 for team 1
        //cashRegister.play();
        incrementScore(score1, ++curValue1);
        
      } else if (event.key === '2') {
        // press 2 for team 2
        //cashRegister.play();
        incrementScore(score2, ++curValue2);
        
      } else if (event.key === '3') {
        // press 3 for team 3
        //cashRegister.play();
        incrementScore(score3, ++curValue3);
        
      }
    }
  });

  document.addEventListener('keyup', (event) => {
    keysPressed[event.key] = false;
  });
});
