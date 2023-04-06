public class CalcBase implements LengthCalc {
    @Override

/** 
 *
 * Calculate
 *
 * @param n  the n. 
 * @param m  the m. 
 * @param p  the p. 
 * @return int
 */
    public int calculate(int n, int m, int p) { 

        int product = n * m * p;
        int result = 0;
        while (product > 0) {
            int digit = product % 10;
            result += digit;
            product /= 10;
        }
        return result;
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

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculate'");
    }
}
