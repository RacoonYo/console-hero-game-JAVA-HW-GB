import checks.IsCorrectOperator;
import checks.IsNumber;

import java.util.Scanner;

public class InPut {
    Scanner scanner = new Scanner(System.in);

    String inPut (String text) {
        System.out.println(text);
        return scanner.next();
    }

    String inPutOperation(String text) {
        while (true) {
            String op = new InPut().inPut(text);
            if (new IsCorrectOperator().isCorrectOperator(op)) return op;
        }
    }

    OperandRational inPutOperand(String text) {
        while (true) {
            String num1 = new InPut().inPut(text);
            if (new IsNumber().isDouble(num1)) {
                return new OperandRational(Double.valueOf(num1));
            }
        }
    }



}
