package com.company;

public class Main {

    public static void main(String[] args) {
	    GameLoop gameLoop = new GameLoop();
        gameLoop.MainGameLoop();
    }
}


// TODO Create a Stones program.
//Simple console line game.
// The rules are simple.  You are a human player and there is a CPU.  There is a pot of 20 stones.
// On your turn, you can choose to take either 1, 2, or 3 stones from the pot.
// Whoever picks the LAST stone is the loser.
// anytime something tries to remove stones, check pot to see how many left, if not enough return invalid choice, if last
// set defeat condition
//computer object: fuzzy logic to pick stones
//pot object: starts with 20 stones
//player object: option to pick 1-3 stones
