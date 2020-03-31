package Guessing_Game;

import java.nio.BufferOverflowException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.ConsoleHandler;

public class GuessTheNumberGame {
    //Fields
    private int guessCount = 0;
    private int input = 100; //changed to int from String because in Java scanner can read the nextInt()
    private RangedRandomInteger secretNumberGenerator = new RangedRandomInteger(); //default constructor

    //Constants:
    private final int MAX_MENU = 3;
    private final int MIN_MENU = 0;

    private final int ABSOLUTE_MIN = 1;
    private final int EASY_MODE = 20;
    private final int MEDIUM_MODE = 100;
    private final int HARD_MODE = 1000;

    //default constructor:
    GuessTheNumberGame(){

    }

    //methods
    public void Start(){
        ShowMenu();
    }

    /*
     * How the Menu should look:
     * "|____________________________________________________|"
     * "|                                                    |"
     * "|  1: Easy                                           |"
     * "|                                                    |"
     * "|  2: Normal                                         |"
     * "|                                                    |"
     * "|  3: Hard                                           |"
     * "|                                                    |"
     * "|  0: Exit                                           |"
     * "|____________________________________________________|"
     */
    private int ShowMenu(){

        //first show the menu
         System.out.println("|____________________________________________________|");
         System.out.println("|                                                    |");
         System.out.println("|  1: Easy                                           |");
         System.out.println("|                                                    |");
         System.out.println("|  2: Normal                                         |");
         System.out.println("|                                                    |");
         System.out.println("|  3: Hard                                           |");
         System.out.println("|                                                    |");
         System.out.println("|  0: Exit                                           |");
         System.out.println("|____________________________________________________|");

         //now read in the user input using a scanner object
        //taken from the MAD9021 brightspace ported to Java
        Scanner reader = new Scanner(System.in);
//        int choice = 100; //not 0 - 3 //do not need to use choice
        boolean validInput = false;
        do {
            System.out.print("\nEnter Choice: ");
            try {
                input = reader.nextInt();
            } catch (InputMismatchException err) {
                System.out.println("Invalid input: " + err.getMessage());
                reader.next(); //clear out the input to avoid infinite scanner loop
            } catch (Exception err){
                System.out.println("Error: " + err.getMessage());
                reader.next(); //clear out the input to avoid infinite scanner loop
            }
            validInput = (input >= MIN_MENU) && (input <= MAX_MENU); //verify the range
            if(!validInput) {
                System.out.println("Please Enter  0, 1, 2 or 3:");
            }
        } while(!validInput);

        System.out.println("You chose: " + input);

        //now lets generate the random num with setup and play the game
        Play(Setup(input));

        return 0; //do this later
    }

    private int Setup(int rangeOption){
        guessCount = 0; //reset the guess count while we are here "setting up"
        switch(rangeOption){
            case 0: //quit the game
                return 0;
            case 1:
                System.out.println("EASY MODE: case " + rangeOption);
                secretNumberGenerator.setMaximum(EASY_MODE);
                break;
            case 2:
                System.out.println("MEDIUM MODE: case " + rangeOption);
                secretNumberGenerator.setMaximum(MEDIUM_MODE);
                break;
            case 3:
                System.out.println("HARD MODE: case " + rangeOption);
                secretNumberGenerator.setMaximum(HARD_MODE);
                break;
            default:
                return -1; //error occurred somewhere bad, possibly hackers
        }

        //now if we reach here the option is validated and the proper mode is set
        //set the minimum to 1 and return the random number
        secretNumberGenerator.setMinimum(ABSOLUTE_MIN);
        return secretNumberGenerator.generateRandomNumber(); //do this later
    }
    private void Play(int secretNumber){
        System.out.println("The Random Number is: " + secretNumber);

        //now read in the user input using a scanner object
        //taken from the MAD9021 brightspace ported to Java
        Scanner reader = new Scanner(System.in);
        boolean validInput = false;
        do {
            System.out.print("\nGuess the Number: ");
            try {
                input = reader.nextInt();
            } catch (InputMismatchException err) {
                System.out.println("Invalid input: " + err.getMessage());
                reader.next(); //clear out the input to avoid infinite scanner loop
            } catch (Exception err){
                System.out.println("Error: " + err.getMessage());
                reader.next(); //clear out the input to avoid infinite scanner loop
            }
            guessCount ++;
//            validInput = (input == secretNumber); //verify the number matches
            //check if the input is higher or lower, if equal loop will break
            if(input > secretNumber) {
                System.out.println("TOO HIGH:\t\t Guess count: " + guessCount);
            } else if (input < secretNumber){
                System.out.println("TOO LOW\t\t Guess count: " + guessCount);
            }
        } while(input != secretNumber);
        //they did it the user beat the game this time
    }

}
