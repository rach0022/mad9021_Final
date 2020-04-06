/*************************
 *
 *  @description The derived sub class of the DLX Dice
 *
 *  @author Ravi Chandra Rachamalla rach0022@algonquinlive.com
 *
 *  @version April 6, 2020
 *
 ***********************/

package Guessing_Game;

public class RangedRandomInteger extends RandomInteger{
    //fields
    //because this is a derived class we also get the fields from the base class
    //RandomInteger which has the fields random and currentNumber
    //maximum is used for the maximum number of the range and vice versa for minimum
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
    //we also have all the getters from the base class
    public int getMinimum() { return minimum; }
    public int getMaximum() { return maximum; }

    //setters
    //maximum must be one or higher
    //we also have all the setters from the base class
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
    //we override theGenerateRandomNumber method from the base class because
    //we want to generate a random number based on our range
    //so we generate the number after doing validate on the maximum and minimum
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
