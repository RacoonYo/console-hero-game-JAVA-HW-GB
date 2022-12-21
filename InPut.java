import checks.IsCorrectOperator;
import checks.IsNumber;

import java.util.Scanner;

public class InPut {
    static Scanner scanner = new Scanner(System.in);
    static LoggerCalc loggerCalc = new LoggerCalc();

    static String inPut (String text) {
        System.out.println(text);
        String input = scanner.next();
        loggerCalc.getLogger().info(text + " // " + input);
        return input;
    }

    static String inPutOperation(String text) {
        while (true) {
            String op = new InPut().inPut(text);
            loggerCalc.getLogger().info(text + " // " + op);
            if (new IsCorrectOperator().isCorrectOperator(op)) return op;
        }
    }

    static OperandRational inPutOperand(String text) {
        while (true) {
            String num1 = new InPut().inPut(text);
            loggerCalc.getLogger().info(text + " // " + num1);
            if (new IsNumber().isDouble(num1)) {
                return new OperandRational(Double.valueOf(num1));
            }
        }
    }
}
