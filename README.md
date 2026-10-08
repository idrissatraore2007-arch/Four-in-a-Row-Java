# Four in a Row

A two-player "four in a row" game written in Java that runs in the terminal. Players take turns dropping their marker into an 8×8 board. The first player to get four markers in a row (horizontally, vertically, or diagonally) wins.

Made for CS200 (Fall 2025) at the University of Wisconsin–Madison.

## How to Run

You need Java installed.

```bash
javac Main.java
java Main
```

## How to Play

- Empty spaces on the board are shown as `o`.
- Player 1 uses `1` and Player 2 uses `2`.
- On your turn, type a column number from 1 to 8.
- Your marker drops to the lowest open spot in that column.
- Get four in a row to win.

## How the Code Works

- **`Main`** starts the game.
- **`Board`** holds the 8×8 grid and all the game logic:
  - `createBoard()` fills the board with empty spaces
  - `printNewBoard()` prints the board
  - `playGame()` runs the turns for both players
  - `stackNumbers()` finds the lowest open row in a column
  - `placeMarker()` puts a marker on the board
  - `checkWin()` checks for four in a row in every direction
## How to Play

1. The empty board is printed. Empty cells are shown as `o`.
2. Player 1 is prompted to pick a column from **1 to 8**.
3. Their marker (`1`) drops into the lowest empty row of that column, and the updated board is printed.
4. Player 2 does the same with marker `2`.
5. Turns alternate until someone gets four in a row.

### Example

```
Player 1 -> What Column? (1-8)
4
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o 1 o o o o
Player 2 -> What Column? (1-8)
5
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o o o o o o
o o o 1 2 o o o
```

When a player connects four:

```
Player 1 has got 4 in a row. Player 1 Wins
```
## Author

Idrissa Traore
