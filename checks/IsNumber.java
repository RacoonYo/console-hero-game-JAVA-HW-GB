package checks;

import java.util.InputMismatchException;

public class IsNumber {

    public boolean isDouble(String num){
        try {
            Double.valueOf(num);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Введёно не число");
            return false;
        }
    }
}
