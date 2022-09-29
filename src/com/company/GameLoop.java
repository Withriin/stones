package com.company;
import stonesLibrary.Strategy;
import stonesLibrary.Validation;
import stonesLibrary.dialog;

import java.util.Scanner;

/**
 * Main loop for program.
 */
public class GameLoop {
    /**
     * While true the program is running.
     * @return boolean
     */
    public boolean MainGameLoop()
    {
        Strategy strategy = new Strategy();
        Scanner userInputScanner = new Scanner(System.in);

        while(true)
        {

            boolean doesUserWantToPlay;

            // Ask if user wants to play
            System.out.println(dialog.intro);
            String userPlayGameInput = userInputScanner.nextLine();
            System.out.println(userPlayGameInput); //testing purposes
            doesUserWantToPlay = Validation.userPlayGameInputValidator(userPlayGameInput);


            // if the player chooses to play will go through loop, if not game exits
            if(doesUserWantToPlay){

                // checks if there needs to be a coinflip to determine first turn. Performs coinflip if necessary.
                // loop
                if (strategy.isCoinFlip()) {
                    System.out.println(dialog.coinFlip);
                    strategy.userCoinFlip(userInputScanner.nextLine());
                }

                // while there are stones left in the pot keep the game running
                while(!strategy.isGameLost()){
                    System.out.println(dialog.potAmount(strategy.getPotAmount()));

                    // Checks if it is the players turn or computers.
                    if (strategy.isPlayerTurn()){

                        // checks if there is less than 3 stones in pot, if yes, display special dialog
                        String playerChoices = (strategy.getPotAmount() < 3) ? dialog.lessThanThreeStonesChoice :
                        dialog.standardRemovalChoice;
                        System.out.println(playerChoices);

                        // Validates player input, subtracts it from the pot total and toggles the players turn.
                        int playerChoice = Validation.playerChoiceConverter(userInputScanner.nextLine());
                        strategy.playerRemoveStones(playerChoice);
                        strategy.togglePlayerTurn();

                    }else{
                        // computers turn
                        System.out.println(dialog.computerTurn(strategy.computerPlayerTurn()));
                    }
                }
                // when the last stone is taken from the pot, show the game over screen and allows the player to play again.
                if (strategy.isGameLost()){
                    System.out.println(dialog.gameConclusion(strategy.getPlayerWins(), strategy.getPlayerLoss()));
                    strategy.newPot();
                    strategy.toggleCoinFlip();
                }

            }else{
                return false;
            }
        }
    }
}
