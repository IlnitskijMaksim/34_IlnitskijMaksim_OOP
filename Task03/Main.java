public class Main {


/** 
 *
 * Main
 *
 * @param args  the args
 */
    public static void main(String[] args) { 

        double alpha = 45; // значення кута у гардусах
        LengthCalc calc = FactoryLengthCalc.createCalculator();
        int sequence_length =  calc.calc(alpha);
        System.out.println("Max units length equal " + sequence_length);
        
        SerializeObject.serialize(sequence_length, "res.ser");
    }
    
}
