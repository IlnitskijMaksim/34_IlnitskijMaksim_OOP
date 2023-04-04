public class FactoryLengthCalc  {

    public static LengthCalc createCalculator() {
        return new NewLengthCalc();
    }
}
