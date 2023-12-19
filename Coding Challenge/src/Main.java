import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner userInput = new Scanner(System.in);
        Method newSentence = new Method();      //Calls new instance of the Method class

        System.out.println("\nWelcome!\n\nHere are the rules for your input to follow:\n" +
                "•\tString starts with a capital letter.\n" +
                "•\tString has an even number of quotation marks.\n" +
                "•\tString ends with one of the following sentence termination characters: \".\", \"?\", \"!\"\n" +
                "•\tString has no period characters other than the last character.\n" +
                "•\tNumbers below 13 are spelled out (”one”, “two”, \"three”, etc…).\n");

        System.out.println("Please enter your sentence:");
        String sentence = userInput.nextLine();
        System.out.println("\nInput Accepted\nStarting validation...");
        newSentence.validate(sentence);     //Calls method to validate user input
        newSentence.validOrInvalid();      //Calls method to check if user's sentence was valid or not
        System.out.println("\n\nWould you like to input another sentence?:\n1. Yes\n2. No");
        newSentence.yesOrNo();      //Calls method to ask user if they want to try again
    }
}