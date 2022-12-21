package checks;

public class IsCorrectOperator {

    public boolean isCorrectOperator(String op){
        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("**")) {
            return true;
        } else {
            System.out.println("Введен не верный оператор");
            return false;
        }
    }
}
