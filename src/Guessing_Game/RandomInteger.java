/*************************
 *
 *  @description The base class of our Dice class
 *
 *  @author Ravi Chandra Rachamalla rach0022@algonquinlive.com
 *
 *  @version April 6, 2020
 *
 ***********************/

package Guessing_Game;
import java.util.Random;

public class RandomInteger {
    //there are the fields for the base class
    //we create a random object and initilize the current random
    //number as zero
    protected Random random = new Random();
    protected int currentRandomNumber = 0;


    //our default constructor for our base class
    public RandomInteger()
    {

    }


    //our public method to generate a random number using the
    //nextInt method of the random object
    public int generateRandomNumber()
    {
        currentRandomNumber = random.nextInt();
        return currentRandomNumber;
    }


    //our getter function to get our random number
    public int getCurrentRandomNumber() { return currentRandomNumber; }
}
