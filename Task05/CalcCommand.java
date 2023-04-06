public class CalcCommand implements Command {
    private final LengthCalc calc;
    private final int n;
    private final int m;
    private final int p;
    private int result;


/** 
 *
 * Calc command
 *
 * @param p  the p. 
 * @param n  the n. 
 * @param m  the m. 
 * @param calc  the calc. 
 * @return public
 */
    public CalcCommand(int p, int n, int m, LengthCalc calc) { 

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

        System.out.println("Undoing calculation command");
        result = 0;
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
