/*************************
 *
 *  @description The "Program" or "Main" Class file that will run the program
 *
 *  @author Ravi Chandra Rachamalla rach0022@algonquinlive.com
 *
 *  @version April 6, 2020
 *
 ***********************/

package Guessing_Game;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Beep Bop!");
        //testing class code
//        RangedRandomInteger x = new RangedRandomInteger(10,20);
        GuessTheNumberGame game = new GuessTheNumberGame(); //create our guessing game object
//        x.setMinimum(30);
//        for(int i = 0; i < 10; i ++){
//            System.out.println("Ranged Random Number X: " +  x.generateRandomNumber());
//        }
        game.Start(); //use the start method of our guessing game object to run the game
    }
}
