package Guessing_Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessTheNumberGame {
    //Fields
    private int guessCount = 0;
    private String input = new String(); // new String seems the same as String.empty()
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
        boolean wantsToPlay = true;
        do {
            ShowMenu();

            if(Integer.parseInt(input) == 0){ //the player chose to exit the game
                break; //break out of the do while loop
            }
            Scanner userChoice = new Scanner(System.in);
            input = userChoice.next(); //validation done by next line for valid strings
            if(input.equalsIgnoreCase("N")){
                wantsToPlay = false;
            }
//            if(input)
        } while(wantsToPlay);
    }

    //THE SHOW menu method used to start the game (initially or again)
    private int ShowMenu(){
        //first clear the screen
        for(int i = 0; i < 40; i++){
            System.out.println(); //for now i will just print 40 lines until i ask tony
        }
        //then show the menu
        System.out.println("|____________________________________________________|");
        System.out.println("| Choose Game Mode:                                  |");
        System.out.println("|                                                    |");
        System.out.println("|  1: Easy                             1 to 20       |");
        System.out.println("|                                                    |");
        System.out.println("|  2: Normal                           1 to 100      |");
        System.out.println("|                                                    |");
        System.out.println("|  3: Hard                             1 to 1000     |");
        System.out.println("|                                                    |");
        System.out.println("|  0: Exit                                           |");
        System.out.println("|____________________________________________________|");

         //now read in the user input using a scanner object
        //taken from the MAD9021 brightspace ported to Java
//        Scanner reader = new Scanner(System.in);
        int choice = 100; //not 0 - 3 //do not need to use choice
        boolean validInput = false;
        do {
            System.out.print("\nEnter Choice: ");
            choice = getGameInput();
            validInput = (choice >= MIN_MENU) && (choice <= MAX_MENU); //verify the range
            if(!validInput) {
                System.out.println("Please Enter  0, 1, 2 or 3:");
            }
        } while(!validInput);

        //now lets generate the random num with setup and play the game
        Play(Setup(choice));

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

        if(secretNumber == 0){ //the player chose 0, exit the game
            return;
        }
        System.out.println("The Random Number is: " + secretNumber);
        //now read in the user input using a scanner object
        //taken from the MAD9021 brightspace ported to Java
//        Scanner reader = new Scanner(System.in);
//        boolean validInput = false;
        int playerInput = 100; //not 0 - 3
        do {
            System.out.print("\nGuess the Number: ");
//            try {
//                input = reader.nextInt();
//            } catch (InputMismatchException err) {
//                System.out.println("Invalid input: " + err.getMessage());
//                reader.next(); //clear out the input to avoid infinite scanner loop
//            } catch (Exception err){
//                System.out.println("Error: " + err.getMessage());
//                reader.next(); //clear out the input to avoid infinite scanner loop
//            }
            playerInput = getGameInput();
            guessCount ++;
//            validInput = (input == secretNumber); //verify the number matches
            //check if the input is higher or lower, if equal loop will break
            if(playerInput > secretNumber) {
                System.out.println("TOO HIGH:\t\t Guess count: " + guessCount);
            } else if (playerInput < secretNumber){
                System.out.println("TOO LOW:\t\t Guess count: " + guessCount);
            }
        } while(playerInput != secretNumber);
        //they did it the user beat the game this time
        System.out.print("\nCongratulations You Won the Game!\n\t\t\t Total Guesses: " + guessCount +" \n\t\t\t Play Again? (y/n): ");
    }

    //helper method to get the user input instead of repeating the try catch each time
    //only used for getting numerical input used for game
    private int getGameInput(){
        Scanner reader = new Scanner(System.in);
        int chosenNumberOption = 100; //not 0 - 3
        try {
            input = reader.nextLine();
            chosenNumberOption = Integer.parseInt(input);
        } catch (InputMismatchException err) {
            System.out.println("Invalid input: " + err.getMessage());
//            reader.next(); //clear out the input to avoid infinite scanner loop
        } catch (Exception err){
            System.out.println("Error: " + err.getMessage());
//            reader.next(); //clear out the input to avoid infinite scanner loop
        }
        return chosenNumberOption; // to do later
    }

}
