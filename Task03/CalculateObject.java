public class CalculateObject implements LengthCalc{

/** 
 *
 * Gets the sequence length
 *
 * @param binaryString  the binary string
 * @return the sequence length
 */
    public static int getSequenceLength (String binaryString) { 

        int max_length = 0;
        int current_length = 0;
        for (int i = 0; i < binaryString.length(); i++){
            if (binaryString.charAt(i) == '1'){
            current_length++;
            max_length = Math.max(max_length, current_length);
        } else {
                current_length = 0;
                }
    }
        return max_length;
    }
    

/** 
 *
 * Calc
 *
 * @param alpha  the alpha
 * @return int
 */
    @Override
    
    public int calc(double alpha){ 

        double radians = alpha * Math.PI / 180; //переведення кута у радіани
        double cos_alpha = Math.cos(radians); //знаходимо значення косинуса кута
        double sum = Math.pow(10 * cos_alpha, 2) + Math.pow(10 * cos_alpha, 3); //обчислення суми квадрата і куба
        int sum_rounded = (int) Math.round(sum); //округлення до цілого числа 
        String sum_binary = Integer.toBinaryString(sum_rounded); //переведення у двійкову систему 
        int sequence_length = getSequenceLength(sum_binary); //знаходження найбільшої довжини послідовності одиниць
        return sequence_length;
    }

}
