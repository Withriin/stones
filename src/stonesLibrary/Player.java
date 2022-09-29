package stonesLibrary;


public class Player {
    private int currentStones;
    private boolean playerTurn;

    private int wins;
    private int loss;

    public Player() {
        this.currentStones = 0;
        this.playerTurn = false;
        this.wins = 0;
        this.loss = 0;

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

    public void winIncrement() {
        wins++;
    }

    public void lossIncrement() {
        loss++;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLoss() {
        return this.loss;
    }
}