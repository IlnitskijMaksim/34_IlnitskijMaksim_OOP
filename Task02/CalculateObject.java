public class CalculateObject {
    public static int getSequenceLength(String binaryString) {
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < binaryString.length(); i++){
            if (binaryString.charAt(i) == '1'){
            currentLength++;
            maxLength = Math.max(maxLength, currentLength);
        } else {
                currentLength = 0;
                }
    }
        return maxLength;
    }
    
    public static int calc(double alpha){
        double radians = alpha * Math.PI / 180; //переведення кута у радіани
        double cos_alpha = Math.cos(radians); //знаходимо значення косинуса кута
        double sum = Math.pow(10 * cos_alpha, 2) + Math.pow(10 * cos_alpha, 3); //обчислення суми квадрата і куба
        int sum_rounded = (int) Math.round(sum); //округлення до цілого числа 
        String sum_binary = Integer.toBinaryString(sum_rounded); //переведення у двійкову систему 
        int sequence_length = getSequenceLength(sum_binary); //знаходження найбільшої довжини послідовності одиниць
        return sequence_length;
    }
}
