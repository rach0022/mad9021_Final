package Guessing_Game;

public class GuessTheNumberGame {
    //Fields
    private int guessCount = 0;
    private String input = "";
    RangedRandomInteger secretNumberGenerator = new RangedRandomInteger(); //default constructor

    //Constants:
    private final int MAX_MENU = 3;
    private final int MIN_MENU = 0;

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
        return 0; //do this later
    }
    private int Setup(int rangeOption){
        return 0; //do this later
    }
    private int Play(int secretNumber){
        return 0; //to do later
    }

}
