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

    public int turn(){
        int stoneRemoval = random.nextInt(2) + 1;
        this.currentStones += stoneRemoval;
        return stoneRemoval;
    }

}
