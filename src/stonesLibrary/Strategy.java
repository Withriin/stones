package stonesLibrary;

import java.util.HashMap;

public class Strategy {
    private Player player;
    private Pot pot;
    private ComputerPlayer computerPlayer;
    private boolean coinFlip;

    public Strategy(){
        this.player = new Player();
        this.pot = new Pot();
        this.computerPlayer = new ComputerPlayer();
        this.coinFlip = true;
    }

    public boolean isCoinFlip(){
        return this.coinFlip;
    }


    public boolean isPlayerTurn() {
        return this.player.isPlayerTurn();
    }

    private void setPlayerTurn(boolean playerTurn) {
        this.player.setPlayerTurn(playerTurn);
    }

    public void togglePlayerTurn(){
        this.player.setPlayerTurn(!(this.player.isPlayerTurn()));
    }
    private CoinFlip getCoinFlip(){
            int coinFlip = (int)(Math.random()*100) % 2;
            if(coinFlip == 1){
                return CoinFlip.HEADS;
            }else{
                return CoinFlip.TAILS;
            }
        }
    public void userCoinFlip(String userCoinFlip){
            if(getCoinFlip() == Validation.userCoinFlipInputValidator(userCoinFlip)){
                this.player.setPlayerTurn(true);}
            else{
                this.player.setPlayerTurn(false);}
            this.coinFlip = false;
    }

    public static String opponentChoice(int pot){
        String opponentChoice = "testOpponentChoice";
        return opponentChoice;
    }
    public void computerPlayerTurn(){
        this.pot.removeStones(this.computerPlayer.turn());
        togglePlayerTurn();
        if(isGameLost()){this.player.winIncrement();}
    }

    public int getPotAmount(){
        return this.pot.potAmount();
    }

    public boolean isGameLost(){
        return this.pot.lostGameCheck();
    }
    public void playerRemoveStones(int stonesToRemove){
        this.pot.removeStones(stonesToRemove);
        this.player.increaseStones(stonesToRemove);
        if(isGameLost()){this.player.lossIncrement();}
    }

    public String getPlayerRecord(){
        HashMap<String, Integer> playerRecord = this.player.getRecord();
        return "Wins " + playerRecord.get("Wins") + ", Losses " + playerRecord.get("Losses");
    }
    public void resetLoss(){
        this.pot.resetLoss();
    }

    public void newPot(){
        this.pot = new Pot();
    }
}
