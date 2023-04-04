public class NewLengthCalc implements LengthCalc {
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
        public int calc(double alpha) {
        double radians = alpha * Math.PI / 180; //переведення кута у радіани
        double cos_alpha = Math.cos(radians); //знаходимо значення косинуса кута
        double sum = Math.pow(100 * cos_alpha, 2) + Math.pow(100 * cos_alpha, 3); //обчислення суми квадрата і куба
        int rounded_sum = (int) Math.round(sum); //округлення до цілого числа
        String binary_sum = Integer.toBinaryString(rounded_sum); //переведення у двійкову систему
        int sequence_length = getSequenceLength(binary_sum); //знаходження найбільшої довжини послідовності одиниць
        return sequence_length;
    }
    
}
