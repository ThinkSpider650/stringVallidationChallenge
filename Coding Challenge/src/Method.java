import java.util.Scanner;
import java.util.ArrayList;

public class Method{
    Boolean valid = true;
    ArrayList<String> invalidReason = new ArrayList<String>();      //Creates new arraylist to store each rule that gets broken by the user input

        public void validate(String sentence) {
            sentence = sentence.replaceAll("\\\\s+", "");       //Replaces all whitespace and invisible characters for efficiency through validation

            if (!Character.isUpperCase(sentence.charAt(0))){        //Checks if user input does not start with a capital letter
                valid = false;
                invalidReason.add("This sentence does not start with a capital letter");
            }


            int countQuotation = 0;

            for (int i = 0; i < sentence.length(); i++) {       //For loop checks each character in the user input
                if (sentence.charAt(i) == '\"') {      //if statement checks for quotation marks, and increments the countQuotation by 1 each time one is found
                    countQuotation++;
                }
            }


            if (countQuotation%2 == 1){        //Checks if user input has an odd number of quotation marks
                valid = false;
                invalidReason.add("This sentence does not have an even number of quotation marks");
            }


            if ((sentence.charAt(sentence.length()-1) != '.') && (sentence.charAt(sentence.length()-1) != '?') && (sentence.charAt(sentence.length()-1) != '!')) {     //Checks if user input does not end with ".", "?", or "!"
                valid = false;
                invalidReason.add("This sentence does not end with \".\", \"?\", or \"!\"");
            }


            boolean containsPeriod = false;

            for (int i = 0; i < sentence.length()-1; i++) {       //For loop checks each character except the last in the user input for period characters, and increments the countPeriod by 1 each time one is found
                if (sentence.charAt(i) == '.') {
                    containsPeriod = true;
                }
            }

            if (containsPeriod) {       //Checks if user input contains a period character, other than the last character
                valid = false;
                invalidReason.add("This sentence has a period character within it other than the last character");
            }


            boolean containsNum = false;

            for (int i = 0; i < 13; i++) {
                if (sentence.contains(String.valueOf(i))) {       ////if statement checks for numbers below 13, and sets containsNum to true if one is found that isn't spelt out
                    containsNum = true;
                }
            }

            if (containsNum) {
                valid = false;
                invalidReason.add("This sentence contains a number below 13 that isn't spelt out");
            }

            System.out.println("\nSentence validation complete.\n-------------------------------------------------------");

        }


        public void validOrInvalid(){      //used to check if the sentence was valid or not
            if (valid){
                System.out.print("\nCongrats, your sentence is valid!");
            } else{
                System.out.println("\nYour sentence does not meet the rules, and therefore is not valid.\nHere is a list of the rules you did not meet: \n");
                int i = 1;

                for (String string : invalidReason){        //Prints each rule the sentence did not follow
                    System.out.println(i + ". " + string);
                    i++;
                }
            }
        }

    public void yesOrNo (){         //Validation for user selection (type and range check)
        int yesOrNoChoice = 0;
        boolean flag;

        do {
            try {
                Scanner yesOrNoInput = new Scanner(System.in);
                yesOrNoChoice = yesOrNoInput.nextInt();
                flag = false;
            } catch (Exception e) {     //Catches inputs that aren't integers
                System.out.println("\nPlease enter a 1 for Yes, and 2 for No");
                flag = true;
            }

        }while(flag);

        if (yesOrNoChoice > 2 || yesOrNoChoice < 1) {       //Checks input is either 1 or 2
            System.out.println("\nPlease enter a 1 for Yes, and 2 for No");
            yesOrNo();
        } else {
            System.out.println("\nAccepted input");
        }

        if (yesOrNoChoice == 1){
            System.out.println("\n-------------------------------------------------------");
            Main.input();        //Calls the input method and allows for another sentence to be input
        } else {
            System.out.println("\nOkay, closing program\nGoodbye.");
            System.exit(0);     //Closes the system
        }
    }

}
