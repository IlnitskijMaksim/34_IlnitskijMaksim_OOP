public class Main {


/** 
 *
 * Main
 *
 * @param args  the args
 */
    public static void main(String[] args) { 

        double alpha = 45; // значення кута у гардусах
        int sequence_length =  CalculateObject.calc(alpha);
        System.out.println("Max units length equal " + sequence_length);
        
        SerializeObject.serialize(sequence_length, "res.ser");
    }
    
}
