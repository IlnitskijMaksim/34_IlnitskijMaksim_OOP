public class Main {

    public static void main(String[] args) {
        double alpha = 30; // значення кута у гардусах
        int sequence_length =  CalculateObject.calc(alpha);
        System.out.println("Max units length equal " + sequence_length);
        
        SerializeObject.serialize(sequence_length, "res.ser");
    }
    
}
