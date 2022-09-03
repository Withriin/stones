package stonesLibrary;

public class Pot {
    private int stones;
    private boolean loss;

    public Pot() {
        this.stones = 20;
        loss = false;
    }

    public int potAmount(){
        return this.stones;
    }

    public void removeStones(int stoneRemoval){
        if(this.stones - stoneRemoval > 0){
            this.stones -= stoneRemoval;
        }else{
            setLoss();
            this.stones = 0;
        }
    }
    private void setLoss(){
        this.loss = true;
    }
    public boolean lostGameCheck(){
        return this.loss;
    }
    public void resetLoss(){
        this.loss = false;
    }
}
