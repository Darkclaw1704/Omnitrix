# GROUP - 90

1. HIMEKSH MALHOTRA , 2022218
2. LAKSHAY KUMAR , 2022266

Git Repository : https://github.com/Darkclaw1704/Omnitrix
__________________________________________________________________________________________________
## Design pattern used

### Factory : 
The `ScreenFactory` class implements the Factory Design Pattern by centralizing the creation of different screen types based on a provided parameter (`screenType`). It enhances modularity, allowing easy addition of new screen types without modifying existing code. The use of a singleton pattern for `EndScreen` and `PauseScreen` ensures a single instance for each screen type. The concise design promotes maintainability and flexibility in managing screen creation logic.

### Singleton : 
The PauseScreen and EndScreen classes are implemented as Singletons, ensuring a single instance for pause and end screens. Access to these instances is facilitated through `PauseScreen.getInstance()`, `EndScreen.getInstance()`, and `ScreenFactory.getInstance()`.
__________________________________________________________________________________________________

## Tests
We have implemented `4 JUNIT Tests`:

In the first test, we validate the Cherry class by setting and retrieving the cherry count, ensuring accurate manipulation. The second test examines the edge case of a zero cherry count, confirming the class handles it robustly. The third and fourth tests assess the Stick class, verifying the accurate storage and retrieval of X and Y coordinates, respectively. These tests ensure the integrity of position handling in the Stick class.

__________________________________________________________________________________________________
## Classes Overview

### 1. Game

Manages the overall game, including scenes, pillars, ninja, stick, cherries, and score.

### 2. GameData

Holds essential game data, including the ninja, stick, score, and layout spacer.

### 3. Ninja

Represents the ninja character, responsible for flipping and falling animations.

### 4. Stick

Represents the stick used by the ninja, providing functionality for extending, rotating, and timing.

### 5. RandomPillarGenerator

Generates random pillars during gameplay and manages their transitions.

### 6. Pillar

Represents the pillars that the ninja jumps between.

### 7. MainMenuApp

Creates the main menu screen with a play button and title.

### 8. PauseScreen

Displays options to continue, play again, or return to the main menu during a pause.

### 9. EndScreen

Shows the player's score and offers options to play again or return to the main menu after the game ends.

### 10. ScreenFactory

A factory class for creating different screens (e.g., PauseScreen, EndScreen).

__________________________________________________________________________________________________

## How to Play

1. **Main Menu**: Click "Play New Game" to start the game.

2. **Gameplay**: Click and hold the mouse to extend the stick. Release to jump between pillars. Time the jumps and stick rotations to land safely.

3. **Pause**: During gameplay, click the pause button to access the pause screen.

4. **Pause Screen**: Choose to continue, play again, or return to the main menu.

5. **End Screen**: After a game over, view your score and choose to play again or return to the main menu.

6. **Revive**: Using 1 cherry, player can revive itself. Revive works if player has 1 or more cherries.

__________________________________________________________________________________________________
## Screenshots

![Main Menu](Screenshot mainMenu.png)

![Gameplay](Screenshot gameScreen.png)

![Pause Screen](Screenshot pauseScreen.png)

![End Screen](Screenshot endScreen.png)
__________________________________________________________________________________________________
## Getting Started

1. Clone the repository: `git clone https://github.com/Darkclaw1704/Omnitrix.git`

2. Open the project in your preferred Java IDE.

3. Run the `Main` class to start the game.


