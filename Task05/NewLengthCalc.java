
/**
 *
 * @author Immrtldrgn
 */
public class NewLengthCalc implements LengthCalc {

/** 
 *
 * Gets the sequence length
 *
 * @param binaryString  the binary string
 * @return the sequence length
 */
    public static int getSequenceLength(String binaryString) {  


        int max_length = 0;
        int current_length = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                current_length++;
                max_length = Math.max(max_length, current_length);
            } else {
                current_length = 0;
            }
        }
        return max_length;
    }
    @Override

/** 
 *
 * Calc
 *
 * @param alpha  the alpha
 * @return int
 */
        public int calculate(int n, int m, int p) {  

        
        double alpha = (double) (n + m + p)/(n * m * p);
        double radians = alpha * Math.PI / 180; //переведення кута у радіани
        double cos_alpha = Math.cos(radians); //знаходимо значення косинуса кута
        double sum = Math.pow(100 * cos_alpha, 2) + Math.pow(100 * cos_alpha, 3); //обчислення суми квадрата і куба
        int rounded_sum = (int) Math.round(sum); //округлення до цілого числа
        String binary_sum = Integer.toBinaryString(rounded_sum); //переведення у двійкову систему
        int sequence_length = getSequenceLength(binary_sum); //знаходження найбільшої довжини послідовності одиниць
        return sequence_length;
    }
        
    @Override

/** 
 *
 * Calculate
 *
 * @param alpha  the alpha. 
 * @return int
 */
    public int calculate(double alpha) { 
        throw new UnsupportedOperationException("Unimplemented method 'calculate'");
    }
}
