package Guessing_Game;
import java.util.Random;

public class RandomInteger {
    protected Random random = new Random();
    protected int currentRandomNumber = 0;

    public RandomInteger()
    {

    }

    public int generateRandomNumber()
    {
        currentRandomNumber = random.nextInt();
        return currentRandomNumber;
    }

    public int getCurrentRandomNumber() { return currentRandomNumber; }
}
