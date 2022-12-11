public class OperandRational extends Operand {
    private final double value;

    public OperandRational(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
