public class Controller {
    void clickButton(){

        boolean flag = true;
            Operator operator = new Operator(InPut.inPutOperation("Введите оператор (+, -, *, /, **)"));
            System.out.println("результат = " + new CalculationRational(operator).getResult());
    }
}
