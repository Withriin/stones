package stonesLibrary;

public class Dialog {
    public static String intro = "Play Game? (1)Yes/(2)No";

    public static String coinFlip = "Coin Flip (H)eads/(T)ails";

    /**
     * Return string that displays the current number of stones in the pot
     * @param potAmount
     * @return String
     */
    public static String potAmount(int potAmount){
        return "Current pot total: " + potAmount;
    }

    public static String lessThanThreeStonesChoice = "Remove (1), (2) Stones";

    public static String standardRemovalChoice = "Remove (1), (2), (3) Stones";

    /**
     * Return string that displays computer players stone removal choice.
     * @param stones
     * @return String
     */
    public static String computerTurn(int stones){
        return "The computer removed " + stones + " stones.";
    }

    /**
     * Return game conclusion Dialog with current player win/loss count.
     * @param wins
     * @param loss
     * @return String
     */
    public static String gameConclusion(int wins, int loss){
        if(loss > 1){
            return "Your Record - Wins: " + wins + " Losses: " + loss;
        }else{
            return "Your Record - Wins: " + wins + " Lost: " + loss;
        }
    }
}
