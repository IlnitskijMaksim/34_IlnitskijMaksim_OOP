
import java.util.Scanner;

public class Main {

    private static Object sequence_length;


/** 
 *
 * Main
 *
 * @param args  the args
 */
    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        System.out.print("Enter m: ");
        int m = scanner.nextInt();

        System.out.print("Enter p: ");
        int p = scanner.nextInt();

        LengthCalc calc = new NewLengthCalc();
        int result = calc.calc(n, m, p);

        System.out.println("Result equals " + result);
        
        SerializeObject.serialize(sequence_length, "res.ser");
    }
    
}
