import java.util.Scanner;


 /**
 * The class Main
 */ 
public class Main {

/** 
 *
 * Main
 *
 * @param args  the args. 
 */
    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in);
        CommandProcessor processor = new CommandProcessor();
        boolean running = true;

        while (running) {
            System.out.println("Enter a command (calculate, undo, exit):");
            String input = scanner.nextLine();

            String[] commandParts = input.split(" ");
            String command = commandParts[0];

            switch (command) {
                case "calculate":
                     int n, m, p;

                     System.out.print("Enter n: ");
                    while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine();
                    }
                    n = scanner.nextInt();

                    System.out.print("Enter m: ");
                    while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine();
                    }
                    m = scanner.nextInt();

                    System.out.print("Enter p: ");
                    while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine();
                    }
                    p = scanner.nextInt();

                    int result = processor.calculate(n, m, p);
                    System.out.println("Result: " + result);
                    break;



                case "undo":
                    processor.undo();
                    System.out.println("Undo performed.");
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command. Please enter calculate, undo or exit");
                    break;
            }
        }

        scanner.close();
    }
}
