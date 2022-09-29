package stonesLibrary;


public class Strategy {
    private final Player player;
    private Pot pot;
    private final ComputerPlayer computerPlayer;
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

    /**
     * Switch between player tunrs.
     */
    public void togglePlayerTurn(){
        this.player.setPlayerTurn(!(this.player.isPlayerTurn()));
    }

    public void toggleCoinFlip(){
        this.coinFlip = !(this.coinFlip);
    }
    private CoinFlip getCoinFlip(){
        int coinFlip = (int)(Math.random()*100) % 2;
        if(coinFlip == 1){
            return CoinFlip.HEADS;
        }else{
            return CoinFlip.TAILS;
        }
    }

    /**
     * Take String input and check if the user won the coinflip.
     * @param userCoinFlip String
     */
    public void userCoinFlip(String userCoinFlip){
        this.player.setPlayerTurn(getCoinFlip() == Validation.userCoinFlipInputValidator(userCoinFlip));
            this.coinFlip = false;
    }

    /**
     * Computes computers turn and returns the computers choice as an integer
     * @return integer
     */

    public int computerPlayerTurn(){
        int computerChoice = this.computerPlayer.turn(getPotAmount());
        this.pot.removeStones(computerChoice);
        togglePlayerTurn();
        if(isGameLost()){this.player.winIncrement();}
        return  computerChoice;
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
    public int getPlayerWins(){
        return player.getWins();
    }
    public int getPlayerLoss(){
        return player.getLoss();
    }

    public void newPot(){
        this.pot = new Pot();
    }
}
