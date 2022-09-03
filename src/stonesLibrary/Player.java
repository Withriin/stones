package stonesLibrary;

import java.util.HashMap;

public class Player {
    private int currentStones;
    private boolean playerTurn;
    private HashMap<String, Integer> record;
    public Player() {
        this.currentStones = 0;
        this.playerTurn = false;
        this.record = new HashMap<String, Integer>();
        record.put("Wins", 0);
        record.put("Losses", 0);
    }


    public int getStones() {
        return this.currentStones;
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void increaseStones(int stoneIncrease) {
        this.currentStones += stoneIncrease;
    }

    public void winIncrement(){
        record.put("Wins", record.get("Wins") + 1);
    }
    public void lossIncrement(){
        record.put("Losses", record.get("Losses") + 1);
    }

    public HashMap<String, Integer> getRecord() {
        return this.record;
    }
}
