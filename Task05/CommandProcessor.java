import java.util.Stack;


 /**
 * The class Command processor
 */ 
public class CommandProcessor {
    private LengthCalc calc;
    private Stack<Command> commandStack;


/** 
 *
 * It is a constructor. 
 *
 */
    public CommandProcessor() { 

        calc = new NewLengthCalc();
        commandStack = new Stack<>();
    }


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

        int result = calc.calculate(n, m, p);
        commandStack.push(new CalcCommand(n, m, p, calc));
        return result;
    }


/** 
 *
 * Undo
 *
 */
    public void undo() { 

        if (!commandStack.isEmpty()) {
            Command lastCommand = commandStack.pop();
            lastCommand.undo();
        }
    }
}
