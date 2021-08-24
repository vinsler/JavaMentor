public class Calculation {
    private static final int a = Calculator.getA();
    private static final int b = Calculator.getB();
    private static final char sign = Calculator.getSign();

    public int subStart() {
        switch (sign) {
            case  '+': {
                return a+b;
            }
            case  '-': {
                return a-b;
            }
            case  '*': {
                return a*b;
            }
            case  '/': {
                return a/b;
            }
        }
        return 0;
    }
}
