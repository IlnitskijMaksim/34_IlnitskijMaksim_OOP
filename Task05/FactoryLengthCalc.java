public class FactoryLengthCalc  {


/** 
 *
 * Create calculator
 *
 * @return LengthCalc
 */
    public static LengthCalc createCalculator() { 

        return new NewLengthCalc();
    }
}
