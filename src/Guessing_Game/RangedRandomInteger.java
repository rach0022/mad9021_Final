package Guessing_Game;

public class RangedRandomInteger extends RandomInteger{
    //fields
    private int minimum = 0;
    private int maximum = 10;


    //default constructor
    public RangedRandomInteger(){

    }
    public RangedRandomInteger(int minimum, int maximum){

    }

    //getters
    public int getMinimum() { return minimum; }
    public int getMaximum() { return maximum; }

    //setters
    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    //methods
    @Override
    public int generateRandomNumber(){
        return 0; //to do later
    }


}
