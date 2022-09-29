package stonesLibrary;
import java.util.Random;
public class ComputerPlayer {
    private int currentStones;

    Random random = new Random();

    public ComputerPlayer() {
        this.currentStones = 0;
    }

    public int getStones() {
        return this.currentStones;
    }

    public int turn(int potStonesAmount) {
        int stoneRemoval;
        if(potStonesAmount == 1 || potStonesAmount == 2){
            stoneRemoval = 1;
        }else{
            stoneRemoval = random.nextInt(2) + 1;
        }
        this.currentStones += stoneRemoval;
        return stoneRemoval;
    }

}
