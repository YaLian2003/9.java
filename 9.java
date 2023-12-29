import java.util.Scanner;

public class AnimalGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BTNode root = new BTNode("elephant");

        while (true) {
            System.out.println("Think of an animal, and I will try to guess it. Ready? (yes/no)");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("no")) {
                break;
            }

            BTNode p = root;
            while (true) {
                if (p.yes == null) {
                    System.out.println("Is it a " + p.text + "? (yes/no)");
                    userInput = scanner.nextLine();

                    if (userInput.equalsIgnoreCase("yes")) {
                        System.out.println("I guessed it! I'm so smart!");
                        break;
                    } else {
                        System.out.println("I give up. What animal were you thinking of?");
                        String A = scanner.nextLine();
                        System.out.println("Please enter a yes/no question that differentiates a " + p.text + " from a " + A + ".");
                        String Q = scanner.nextLine();
                        System.out.println("What is the correct answer for a " + A + "? (yes/no)");
                        char YesNo = scanner.nextLine().charAt(0);

                        BTNode Y = new BTNode(YesNo == 'y' ? A : p.text);
                        BTNode N = new BTNode(YesNo == 'n' ? A : p.text);

                        p.text = Q;
                        p.yes = Y;
                        p.no = N;

                        break;
                    }
                } else {
                    System.out.println(p.text + " (yes/no)");
                    userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("yes")) {
                        p = p.yes;
                    } else {
                        p = p.no;
                    }
                }
            }
        }
        scanner.close();
    }
}
