import java.util.Scanner;

public class Hangman {
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {
    "+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //NOTE: Problem -> I use \\ instead of \ cause \ not work!
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
      int tryNumb = 0;
      int maxTry = 6;
      char[] missesLetters = new char[maxTry + 1];
      //Task 1 - Choose the random word
      int randomNumb = (int) (Math.random() * words.length);
      String theWord = words[randomNumb];

      //Task 2 - Convert the word string to an array of characters 
      char[] theWordCharArray = new char[theWord.length()]; 
      for (int i=0; i < theWord.length();i++) {  
        theWordCharArray[i] = theWord.charAt(i);  
      }

      //Task 2.1 - Make an array of placeholders
      char[] placeHoldersArray = new char[theWord.length()];
      for(int i = 0 ; i < theWord.length() ; i++) {
        placeHoldersArray[i] = '_';
      }

      //Task exc - Tell the rules and the game what's about
      System.out.println("Welcome to the hangman game");
      System.out.println("You must guess the animal with your char you give in.");
      System.out.println("Careful. You have only 6 try for wrong guess");
      System.out.println("\n\n");
      //Task 3 - Make the loop print all things again
      //         and again, let user the max  of 6 try
      for(tryNumb = 0; tryNumb < maxTry;) {
        //Task 4 - Print the gallows
        showTheGallows(tryNumb);

        //Task 5 - Print the place holders by the word size
        System.out.print("Word:\t");
        printAnArray(placeHoldersArray , theWord.length());
        System.out.print("\n\n");
      
        //Task 6 -Print the  Misses
        System.out.print("Misses:\t");
        printAnArray(missesLetters , maxTry);
        System.out.print("\n\n");
      
        //Task 7 - get the letter from the user
        System.out.print("Guess:\t");
        char guessLetter = scan.next().charAt(0);

        //Task 8 - check the letter 
        //Task 8.1 if its correct change the placeHolderArray
        boolean isItCorrect = false;
        for(int j = 0 ; j < theWord.length(); j++) {
          if(guessLetter == theWord.charAt(j)) {
          placeHoldersArray[j] = guessLetter;
          isItCorrect = true;

          }
        }
        //Task 8.2 if its wrong change the missesLettersArray
        if (!isItCorrect) {
          missesLetters[tryNumb] = guessLetter;
          tryNumb++;

        }
               
        //Task 9 - Check Win
        boolean isWin = true;
        for(int j = 0 ; j < theWord.length() ; j++) {
          if (placeHoldersArray[j] == '_') {
            isWin = false;
            break;
          }
        }
        if (isWin) {
          System.out.println("Word:\t" + theWord);
          System.out.println("Nice job, Well done!");
          System.exit(0);
        }
      }
      //Task 9.1 - Loose!
      System.out.println(gallows[6]);
      System.out.println("Rip!");
      System.out.println("\nThe word was:\t" + theWord + "\n");
    }

    public static void showTheGallows (int tryNumb) {
        System.out.print(gallows[tryNumb]);
    }

    public static void printAnArray (char[] array ,int arrayLength) {
      for(int i = 0; i < arrayLength ; i++) {
        System.out.print(array[i] + " ");
      }
    }
}





