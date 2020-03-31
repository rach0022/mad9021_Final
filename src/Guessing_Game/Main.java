package Guessing_Game;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Beep Bop!");
        //testing class code
//        RangedRandomInteger x = new RangedRandomInteger(10,20);
        GuessTheNumberGame game = new GuessTheNumberGame();
//        x.setMinimum(30);
//        for(int i = 0; i < 10; i ++){
//            System.out.println("Ranged Random Number X: " +  x.generateRandomNumber());
//        }
        game.Start();
    }
}
