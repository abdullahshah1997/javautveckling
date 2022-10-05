import java.util.Scanner;
public class CalculatorNew {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Skapar en while loop som ser till att programmet körs tills användaren avbryter det.
        while (true)
        {
            System.out.println("Ange din räkneoperation. Ange \"x\" för att avsluta.");
            String operation = scan.nextLine();
            //Tar bort alla mellanslag i input genom att byta ut dem mot "ingenting".
            operation = operation.replace(" ", "");
            //Gör operation till små bokstäver för att enklare kunna skriva koden för att avsluta programmet genom att
            //skriva in bokstaven x.
            operation = operation.toLowerCase();

            //Skapar ett felmeddelande för tomt uttryck.
            boolean emptyExpression = operation.equals("");
            if (emptyExpression) {
                System.out.println("Uttrycket får inte vara tomt!");
            }//if

            //Skapar ett felmeddelande då uttrycket saknar operatorer.
            boolean noOperator = !operation.contains("+") && !operation.contains("-") && !operation.contains("*")
                    && !operation.contains("/") && !operation.equals("x");
            if(noOperator&&!operation.isBlank()) {
                System.out.println("Uttrycket måste innehålla en av följande operatorer: +, -, *, /");
            }//if

            //Skapar ett felmeddelande då uttrycket innehåller färre än två operander.
            String firstCharacter = "";
            if(!operation.equals(""))
                firstCharacter = "" + operation.charAt(0);
            boolean firstCharacterIsDigit=false;
            if(!operation.equals(""))
                firstCharacterIsDigit = Character.isDigit(operation.charAt(0));
            boolean tooFewOperands = ((!firstCharacterIsDigit) && (!firstCharacter.equals("-"))) ||
                    !Character.isDigit(operation.charAt(operation.length() - 1));
            if(!operation.equals("x")&&!operation.isBlank())
                if (tooFewOperands) {
                    System.out.println("Uttrycket måste innehålla två (reella) operander!");

                }//if

            //Skapar ett felmeddelande vid division med 0.
            char charAfterDivision = 1;
            if(!operation.equals(""))
                if(operation.lastIndexOf("/")!=operation.length()-1)
                    charAfterDivision = operation.charAt(operation.indexOf("/") + 1);
            String potentialZero = Character.toString(charAfterDivision);
            if(potentialZero.equals("0"))
                System.out.println("Division med 0 ej tillåten!");

            //Räknar antalet operatorer i uttrycket med en loop.
            int count = 0;
            int countPlus = 0;
            int countMinus = 0;
            int countDivision = 0;
            int countMultiplication = 0;

            for (count = 0; count <= operation.length() - 1; count++) {
                String operatorChecker = "" + operation.charAt(count);
                if (operatorChecker.equals("+")) {
                    countPlus++;
                }//if

                else if (operatorChecker.equals("-")) {
                    countMinus++;
                }//else if

                else if (operatorChecker.equals("*")) {
                    countMultiplication++;
                }//else if

                else if (operatorChecker.equals("/")) {
                    countDivision++;
                }//else if

            }//for loop

            //Skriver ut felmeddelande vid för många operatorer.

            int allOperators = countPlus+countDivision+countMultiplication+countMinus;

            if(countPlus+countDivision+countMultiplication>=2)
                System.out.println("För många operatorer!");

            else if(countPlus>1||countDivision>1||countMultiplication>1)
                System.out.println("För många operatorer!");

            else if(countMinus>3||(countMinus==3&&!operation.contains("--"))||operation.contains("---"))
                System.out.println("För många operatorer!");

            else if(countPlus+countDivision>1)
                System.out.println("För många operatorer!");

            else if(countPlus+countMultiplication>1)
                System.out.println("För många operatorer!");

            else if(countDivision+countMultiplication>1)
                System.out.println("För många operatorer!");

            //Skapar kod som räknar index för de operatorer som finns med i uttrycket.
            boolean containsOperator = operation.contains("+")||operation.contains("-")||operation.contains("*")
                    ||operation.contains("/");
            int operatorIndex=0;
            if(!operation.equals(""))
                if(containsOperator)
                    while(operation.charAt(operatorIndex)!='-'&&operation.charAt(operatorIndex)!='+'
                            &&operation.charAt(operatorIndex)!='*'&&operation.charAt(operatorIndex)!='/')
                        operatorIndex++;

            int operator2Index=operatorIndex+1;

            if(allOperators>1) {
                while (operation.charAt(operator2Index) != '-' && operation.charAt(operator2Index) != '+'
                        && operation.charAt(operator2Index) != '*' && operation.charAt(operator2Index) != '/') {
                    operator2Index++;
                }//while
            }//if
            else
                operator2Index=operatorIndex;

            int operator3Index=operator2Index+1;
            if(allOperators>2)
                while(operation.charAt(operator3Index)!='-'&&operation.charAt(operator3Index)!='+'
                        &&operation.charAt(operator3Index)!='*'&&operation.charAt(operator3Index)!='/')
                    operator3Index++;
            else if(allOperators==2)
                operator3Index=operator2Index;
            else
                operator3Index=operatorIndex;

            String firstNumber = "Hittade inte första numret.";
            String secondNumber = "Hittade inte andra numret.";
            String operator = "Hittade inte operatorn.";
            //Operanderna och operatorn om första tecknet är negativt och ett positivt tal subtraheras från det.
            if(!operation.equals(""))

                if(operation.charAt(0)=='-' && countMinus==2 && countDivision== 0 && countPlus==0 && countMultiplication==0) {
                    firstNumber = operation.substring(0, operation.lastIndexOf("-"));
                    secondNumber = operation.substring(operation.lastIndexOf("-")+1);
                    operator = "-";
                }//if

                //Operanderna och operatorn om första tecknet är negativt och andra talet är positivt och en operation sker
                //mellan dem.
                else if(operation.charAt(0)=='-'&&countMinus==1&&countDivision+countMultiplication+countPlus==1) {
                    firstNumber = operation.substring(0, operator2Index);
                    secondNumber = operation.substring(operator2Index + 1);
                    operator = Character.toString(operation.charAt(operator2Index));
                }//else-if
                //Operanderna och operatorn om första talet är negativt och det senare är negativt samt en annan operation
                //sker mellan dem.
                else if(operation.charAt(0)=='-'&&countMinus==2&&(countDivision==1||countMultiplication==1||countPlus==1)
                        &&countDivision+countMultiplication+countPlus==1) {
                    firstNumber = operation.substring(0, operator2Index);
                    secondNumber = operation.substring(operator3Index);
                    operator = Character.toString(operation.charAt(operator2Index));
                }//else-if

                //Operanderna och operatorn om första talet är negativt och det senare är negativt samt subtraktion
                //sker mellan dem.

                else if(operation.charAt(0)=='-'&&countMinus==3&&countDivision+countMultiplication+countPlus==0) {
                    firstNumber = operation.substring(0, operator2Index);
                    secondNumber = operation.substring(operator3Index);
                    operator = "-";
                }//else-if

                //Operanderna och operatorn om första talet är positivt och det senare är negativt.
                else if(Character.isDigit(operation.charAt(0))&&(countMinus+countPlus==2||countMinus+countDivision==2||
                        countMinus+countMultiplication==2)) {
                    firstNumber = operation.substring(0, operatorIndex);
                    secondNumber = operation.substring(operator3Index);
                    operator = Character.toString(operation.charAt(operatorIndex));
                }//else-if

                //Operanderna och operatorn om båda tal är positiva.
                else if (operatorIndex!=operation.length()-1)
                    if(Character.isDigit(operation.charAt(0))&&Character.isDigit(operation.charAt(operatorIndex+1))) {
                        firstNumber = operation.substring(0, operatorIndex);
                        secondNumber = operation.substring(operatorIndex + 1);
                        operator = Character.toString(operation.charAt(operatorIndex));
                    }//else-if

            //Felmeddelande vid för många operander.
            if(operatorIndex>0)
                if(operatorIndex!=operation.length()-1){
                    if (Character.isDigit(operation.charAt(operatorIndex - 1)) &&
                            Character.isDigit(operation.charAt(operatorIndex + 1))
                            && Character.isDigit(operation.charAt(operator2Index + 1))&&operatorIndex!=operator2Index) {
                        System.out.println("För många operander!");
                    }//inner if
                }//outer if
                else if(operatorIndex==0) {
                    if(!operation.equals(""))
                        if (Character.isDigit(operation.charAt(operatorIndex + 1))
                                && Character.isDigit(operation.charAt(operator2Index + 1))
                                && Character.isDigit(operation.charAt(operator3Index + 1))&&operatorIndex!=operator2Index&&operatorIndex
                                !=operator3Index&&operator2Index!=operator3Index) {
                            System.out.println("För många operander!");
                        }//inner if
                }//outer else-if

            //Här omvandlas det utklippta talet från sträng till double.
            double firstDouble= 6.39239913982293;
            double secondDouble = 3.267842924294;
            if(containsOperator)
                if(!firstNumber.equals("Hittade inte första numret."))
                    if(!operation.equals("")) {
                        if (firstNumber.charAt(0) == '-')
                            firstDouble = -Double.parseDouble(firstNumber.substring(1));
                        else
                            firstDouble = Double.parseDouble(firstNumber);

                        if (secondNumber.charAt(0) == '-')
                            secondDouble = -Double.parseDouble(secondNumber.substring(1));
                        else if (!operation.equals(""))
                            if(!secondNumber.contains("*")&&!secondNumber.contains("/")&&!secondNumber.contains("+"))
                                secondDouble = Double.parseDouble(secondNumber);
                    }//outer if, !(operation.equals)
            double finalDouble;
            //Här sker uträkningen.
            if(operator.equals("-"))
                finalDouble = firstDouble-secondDouble;
            else if(operator.equals("+"))
                finalDouble = firstDouble+secondDouble;
            else if(operator.equals("*"))
                finalDouble = firstDouble*secondDouble;
            else
                finalDouble = firstDouble/secondDouble;

            //Här printas svaret ut.
            if(!(countPlus+countDivision+countMultiplication>1)&&!(countMinus>3))
                if(containsOperator)
                    if(!operation.equals(""))
                        if(operatorIndex!=operation.length()-1)
                            if(operation.charAt(0)!='/'&&operation.charAt(0)!='*'&&operation.charAt(0)!='+')
                                if(!tooFewOperands&&secondDouble!=0)
                                    System.out.println(finalDouble);

            if(operation.equals("x")) {
                System.out.println("Kalkylatorn är avslutad.");
                break;
            }//if
        }//while
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
    }//main
}//class