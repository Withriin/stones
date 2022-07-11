package com.company;
import stonesLibrary.dialog;
import stonesLibrary.strategy;
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
        while(true)
        {
            // Create objects block
            Scanner userInputScanner = new Scanner(System.in);
            boolean doesUserWantToPlay = true;
            boolean coinFlip = true;

            // Ask if user wants to play
            System.out.println(dialog.intro);
            String userPlayGameInput = userInputScanner.nextLine();
            // TODO add validation
            System.out.println(userPlayGameInput);

            // if the player chooses to play will go through loop, if not game exits
            while(doesUserWantToPlay == true){

                boolean playerTurn;

                // checks if there needs to be a coinflip to determine first turn.  Sets coinflip to false for ongoing
                // loop
                if (coinFlip == true) {
                    System.out.println(dialog.coinFlip);
                    String userCoinFlipInput = userInputScanner.nextLine();
                    Enum userCoinFlipEnum = userCoinFlipInput;

                    if (userCoinFlipEnum == strategy.coinFlip()) {
                        playerTurn = true;
                        coinFlip = false;
                    } else {
                        playerTurn = false;
                        coinFlip = false;
                    }
                }
                while(pot > 0){
                    System.out.println("Current pot total");
                    // if it is the players turn run the if statement, if it is the opponents run the else statement
                    if (playerTurn == true ){
                        // checks if there is less than 3 stones in pot, if yes, display special dialog
                        String playerChoices = (pot < 3) ? dialog.lessThanThreeStonesChoice :
                        dialog.standardRemovalChoice;
                        System.out.println(playerChoices);
                        String playerChoice = userInputScanner.nextLine();
                        // TODO add playerChoice input validation
                        // TODO playerChoice choice validation
                        // TODO remove stones from pot = playerChoice

                        // check if the pot is empty after taking stones, if it is not change turn to other party
                        if (pot > 0){
                            playerTurn = false;
                        }else{
                            break;
                        }
                    }else{
                        String opponentChoice = strategy.opponentChoice(iPot);
                        System.out.println(opponentChoice);
                        // TODO remove stones from pot = opponentChoice

                        // check if the pot is empty after taking stones, if it is not change turn to other party
                        if (pot > 0){
                            playerTurn = true;
                        }else {
                            break;
                        }
                    }
                }
                //pot is 0
                // TODO lastStoneTaken victory condition
                // TODO save victory condition, add to stats, print current records
                System.out.println(dialog.playAgain);
                String playAgainChoice = userInputScanner.nextLine();
                // TODO playAgainChoice validation and restart
                // TODO end game
            }
            return false;
        }
    }
}

/*
            create pot object, player object, computer object, stoneInPot bool set to true, coinflip bool set true
            print play game
                yes- continue into game loop
                    check coinflip bool if true run coinflip dialog
                    coinflip dialog/set coinflip bool to false
                    userInput
                    debug/check userInput
                    if won set turn=player, if lost set turn=computer
                    while pot > 0
                        print how many stones in pot
                        if player run this
                            print standardRemovalChoice
                            take userInput
                            check userInput vs options *if invalid use invalid input dialog
                            remove stones from pot = userInput
                            if pot > 0
                                set turn=computer
                            else
                                exit loop
                        else
                            get computerChoice
                            remove stones from pot = computerChoice
                            if pot > 0
                                set turn=player
                            else
                                exit loop
                   *when pot is no longer 0*
                   set lastStoneTaken = turn
                   lastStoneTaken used to compute victoryCondition
                   save victory condition
                   print current records
                   ask to play again
                        yes
                            restart loop
                        no
                            return 0 close game
                no- return 0 close game

             */