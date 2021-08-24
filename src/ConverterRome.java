import java.util.TreeMap;

public class ConverterRome {
    public static int convertRomeToArabic(String expression) {
        switch(expression)
        {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
        }
        return 0;
    }

    private static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String convertArabicToRome(int expressionInt) {
        int i = map.floorKey(expressionInt);
        if (expressionInt == i) {
            return map.get(expressionInt);
        }
        return map.get(i) + convertArabicToRome(expressionInt-i);
    }
}
