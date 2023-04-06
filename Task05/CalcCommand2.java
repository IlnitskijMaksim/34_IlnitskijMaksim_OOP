public class CalcCommand2 implements Command {
    private final LengthCalc calc;
    private final int n, m, p;
    private int result;


/** 
 *
 * Calc command2
 *
 * @param calc  the calc. 
 * @param n  the n. 
 * @param m  the m. 
 * @param p  the p. 
 * @return public
 */
    public CalcCommand2(LengthCalc calc, int n, int m, int p) { 

        this.calc = calc;
        this.n = n;
        this.m = m;
        this.p = p;
    }

    @Override

/** 
 *
 * Execute
 *
 */
    public void execute() { 

        result = calc.calculate(n, m, p);
        System.out.println("Result: " + result);
    }

    @Override

/** 
 *
 * Undo
 *
 */
    public void undo() { 

        System.out.println("Undoing calculation...");
    }
    

/** 
 *
 * Gets the result
 *
 * @return the result
 */
    public int getResult() { 

        return result;
    }
}
