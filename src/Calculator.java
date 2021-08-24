import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    private static int a;
    private static int b;
    private static char sign = 'z';
    private static boolean Rome = false;

    public void input() {
        String expression;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            expression = reader.readLine().replaceAll("\\s","");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода строки.");
        }
        // определяем знак
        if (expression.contains("+"))
            sign = '+';
        else if (expression.contains("-"))
            sign = '-';
        else if (expression.contains("*"))
            sign = '*';
        else if (expression.contains("/"))
            sign = '/';
        else  throw new RuntimeException("Ошибка знака.");
        // если после знака, до конца строки есть еще один, то ошибка
        if ((expression.substring(expression.indexOf(sign) + 1, expression.length()).contains("+"))
        || (expression.substring(expression.indexOf(sign) + 1, expression.length()).contains("-"))
            || (expression.substring(expression.indexOf(sign) + 1, expression.length()).contains("*"))
                || (expression.substring(expression.indexOf(sign) + 1, expression.length()).contains("/")))
            throw new RuntimeException();
        // если операторы разные, то ошибка
        try {
            Integer.parseInt(expression.substring(0, expression.indexOf(sign)));
            try {
                Integer.parseInt(expression.substring(expression.indexOf(sign) + 1, expression.length()));
            } catch (NumberFormatException e0) {
                throw new RuntimeException();
            }
        } catch (NumberFormatException e1) {
            try {
                Integer.parseInt(expression.substring(expression.indexOf(sign) + 1, expression.length()));
                throw new RuntimeException();
            } catch (NumberFormatException e2) {
                Rome = true;
            }
        }
        // если операторы римские, конвертируем для расчета
        if (Rome) {
            a = ConverterRome.convertRomeToArabic(expression.substring(0, expression.indexOf(sign)));
            b = ConverterRome.convertRomeToArabic(expression.substring(expression.indexOf(sign) + 1, expression.length()));
        } else {
            a = Integer.parseInt(expression.substring(0, expression.indexOf(sign)));
            b = Integer.parseInt(expression.substring(expression.indexOf(sign) + 1, expression.length()));
        }
    }

    public static void main(String[] args) {
            Calculator calculator = new Calculator();
            calculator.input();
            Calculation calculation = new Calculation();
            if (Rome) {
                if (calculation.subStart() > 0)
                    System.out.println(ConverterRome.convertArabicToRome(calculation.subStart()));
                else throw new RuntimeException("Отрицательное число.");
            } else {
                System.out.println(calculation.subStart());
            }
    }

    public static int getA(){
        return a;
    }

    public static int getB() {
        return b;
    }

    public static char getSign() {
        return sign;
    }
}
