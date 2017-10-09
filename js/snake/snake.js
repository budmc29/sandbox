var ROWS = 50;
var COLS = 50;
var snake = [];
var SNAKE_INITIAL_LENGTH = 5;

function init() {
  for (var i = 0; i < SNAKE_INITIAL_LENGTH; ++i) {
    snake.push({
      x: Math.floor(COLS / 2) - i,
      y: Math.floor(ROWS / 2)
    });
  }
}

init();
