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
            // Create objects block

            boolean doesUserWantToPlay;

            // Ask if user wants to play
            System.out.println(dialog.intro);
            String userPlayGameInput = userInputScanner.nextLine();
            System.out.println(userPlayGameInput); //testing purposes
            doesUserWantToPlay = Validation.userPlayGameInputValidator(userPlayGameInput);
            strategy.resetLoss();

            // if the player chooses to play will go through loop, if not game exits
            if(doesUserWantToPlay){

                // checks if there needs to be a coinflip to determine first turn. And does coinflip if necessary.
                // loop
                if (strategy.isCoinFlip()) {
                    System.out.println(dialog.coinFlip);
                    strategy.userCoinFlip(userInputScanner.nextLine());
                }

                // while there are stones left in the pot keep the game running
                while(!strategy.isGameLost()){
                    System.out.println("Current pot total " + strategy.getPotAmount());

                    // if it is the players turn run the if statement, if it is the opponents run the else statement
                    if (strategy.isPlayerTurn()){

                        // checks if there is less than 3 stones in pot, if yes, display special dialog
                        String playerChoices = (strategy.getPotAmount() < 3) ? dialog.lessThanThreeStonesChoice :
                        dialog.standardRemovalChoice;
                        System.out.println(playerChoices);
                        int playerChoice = Validation.playerChoiceConverter(userInputScanner.nextLine());
                        strategy.playerRemoveStones(playerChoice);
                        strategy.togglePlayerTurn();

                    }else{
                        String opponentChoice = Strategy.opponentChoice(strategy.getPotAmount());
                        System.out.println(opponentChoice);
                        strategy.computerPlayerTurn();
                    }
                }

                if (strategy.isGameLost()){
                    System.out.println(dialog.gameConclusion);
                    System.out.println(strategy.getPlayerRecord());
                    strategy.newPot();
                }

            }else{
                return false;
            }
        }
    }
}
