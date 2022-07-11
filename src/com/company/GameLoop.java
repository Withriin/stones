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
            Boolean doesUserWantToPlay = true;
            Boolean coinFlip = true;

            // Ask if user wants to play
            System.out.println(dialog.intro);
            String userPlayGameInput = userInputScanner.nextLine();
            // TODO add validation
            System.out.println(userPlayGameInput);

            while(doesUserWantToPlay == true){

                Boolean playerTurn;

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

            }
            return false;
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
        }
    }
}
