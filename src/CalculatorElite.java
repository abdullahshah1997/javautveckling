import java.util.Scanner;

public class CalculatorElite {

    public static void main(String[] args) {
//    runTests();

        Scanner scanner = new Scanner(System.in);
        var isRunning = true;
        while (isRunning) {
            var input = scanner.nextLine();
            if (input.equals("stop")) {
                isRunning = false;
            } else {
                var result = calculateInput(input);
                System.out.println(input + " = " + result);
            }
        }
    }

    public static String calculateInput(String input) {
        if (input.isBlank()) {
            return "Tom sträng är ogiltigt";
        }

        var operator = getOperator(input);

        if (operator == null) {
            return "Giltig operator saknas";
        }

        var operatorIndex = getOperatorIndex(input, operator);
        var leftOperandString = input.substring(0, operatorIndex);
        var rightOperandString = input.substring(operatorIndex + 1);

        Double leftOperand, rightOperand;

        try {
            leftOperand = Double.parseDouble(leftOperandString);
            rightOperand = Double.parseDouble(rightOperandString);
        } catch (NumberFormatException numberFormatException) {
            return "Det matematiska uttrycket måste bestå av två operander (reela tal) och en operator.";
        }

        switch (operator) {
            case "+":
                return leftOperand + rightOperand + "";
            case "-":
                return leftOperand - rightOperand + "";
            case "*":
                return leftOperand * rightOperand + "";
            case "/":
                if (rightOperand == 0) {
                    return "Får inte dela med 0";
                }
                return leftOperand / rightOperand + "";
        }

        return "fail mofa";
    }

    private static String getOperator(String input) {
        var isLeftOperandNegative = input.charAt(0) == '-';
        return input.contains("+") ? "+" : (isLeftOperandNegative ? input.substring(1) : input).contains("-") ? "-" : input.contains("*") ? "*" : input.contains("/") ? "/" : null;
    }

    private static int getOperatorIndex(String input, String operator) {
        var isLeftOperandNegative = input.charAt(0) == '-';
        var fromIndex = operator.equals("-") && isLeftOperandNegative ? 1 : 0;
        return input.indexOf(operator, fromIndex);
    }

    public static void runTests() {
//        System.out.println(calculateInput("1+2") + " Ska bli 3");
//        System.out.println(calculateInput("-200-100") + " Ska bli -300");
//        System.out.println(calculateInput("2*5.5") + " Ska bli 11");
//        System.out.println(calculateInput("2.5*5") + " Ska bli 12.5");
//        System.out.println(calculateInput("10/2") + " Ska bli 5");
//        System.out.println(calculateInput("") + " Ska ge ett felmeddelande om att tom sträng är ogiltigt");
//        System.out.println(calculateInput("     ") + " Ska ge ett felmeddelande om att tom sträng är ogiltigt");
//        System.out.println(calculateInput("10%12") + " Ska ge ett felmeddelan∫de att giltig operator saknas");
//        System.out.println(calculateInput("1234") + " Ska ge ett felmeddelande att giltig operator saknas");
//        System.out.println(calculateInput("1+2*2") + " Ska ge ett felmeddelande att för många operatorer");
//        System.out.println(calculateInput("5/") + " Ska ge ett felmeddelande att två operander krävs");
//        System.out.println(calculateInput("*3") + " Ska ge ett felmeddelande att två operander krävs");
//        System.out.println(calculateInput("hej*tja") + " Ska ge ett felmeddelande att operander måste vara reella tal");
//        System.out.println(calculateInput("5/0") + " Ska ge ett felmeddelande att man inte får dela med 0");
    }
}
