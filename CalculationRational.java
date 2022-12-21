public class CalculationRational {
    private Operator operator;
    private double result;

    public double getResult() {
        return result;
    }

    public CalculationRational(Operator operator) {
        this.operator = operator;

        switch (operator.value()) {
            case "+" -> add(InPut.inPutOperand("Введите первое число"),
                           InPut.inPutOperand("Введите второе число"));
            case "-" -> subtraction(InPut.inPutOperand("Введите первое число"),
                                    InPut.inPutOperand("Введите второе число"));
            case "*" -> multiplication(InPut.inPutOperand("Введите первое число"),
                                        InPut.inPutOperand("Введите второе число"));
            case "/" -> division(InPut.inPutOperand("Введите первое число"),
                                    InPut.inPutOperand("Введите второе число"));
            case "**" -> degree(InPut.inPutOperand("Введите число"),
                    InPut.inPutOperand("Введите степень"));
        }
    }

    private void add (OperandRational num1, OperandRational num2) {
        result = num1.getValue() + num2.getValue();
    }

    private void subtraction(OperandRational num1, OperandRational num2) {
        result = num1.getValue() - num2.getValue();
    }

    private void multiplication(OperandRational num1, OperandRational num2) {
        result = num1.getValue() * num2.getValue();
    }

    private void division(OperandRational num1, OperandRational num2) {
        result = num1.getValue() / num2.getValue();
    }

    private void degree(OperandRational num, OperandRational degree){
        result = Math.pow(num.getValue(), degree.getValue());
    }
}
