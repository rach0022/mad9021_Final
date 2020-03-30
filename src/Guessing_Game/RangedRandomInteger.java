package Guessing_Game;

public class RangedRandomInteger extends RandomInteger{
    //fields
    private int minimum = 0;
    private int maximum = 10;


    //default constructor
    public RangedRandomInteger(){

    }
    public RangedRandomInteger(int minimum, int maximum){
        setMaximum(maximum);
        setMinimum(minimum);
    }

    //getters
    public int getMinimum() { return minimum; }
    public int getMaximum() { return maximum; }

    //setters
    //maximum must be one or higher
    public void setMaximum(int maximum) {
        if(maximum >= 1){
            this.maximum = maximum;
        }
    }

    //must be zero or higher
    public void setMinimum(int minimum) {
        if(minimum >= 0){
            this.minimum = minimum;
        }
    }

    //methods
    @Override
    public int generateRandomNumber(){

        //validate that minimum is smaller than maximum
        if(minimum > maximum){
            int temp = maximum;
            maximum = minimum; //make sure maximum is greater than minimum
            minimum = temp;
        }
        if(maximum == minimum){
            currentRandomNumber = minimum;
        } else {
            currentRandomNumber = random.nextInt((maximum - minimum)+ 1) + minimum; //get a random number in the range of max/ min inclusive
        }
        return currentRandomNumber; //to do later
    }


}
