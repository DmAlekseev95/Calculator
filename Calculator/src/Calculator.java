import java.util.Scanner;

public class Calculator {
    public static void main (String[] agrs) throws Exception{
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Введите выражение состоящее из 2 арабских чисел от 1 до 10 или из римских от I до X и из знаков +,-,*,/");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }
    public static String parse (String expression) throws Exception {
        int num1;
        int num2;
        String oper;
        String result;
        boolean isRoman;
        String[] operands = expression.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Выражение должно состоять из 2 операндов и 1 оператора");
        oper = detectOperation(expression);
        if (oper == null) throw new Exception("Должен быть 1 оператор +,-,*,/");
        if (RomanInteger.isRoman(operands[0]) && RomanInteger.isRoman(operands[1])){
            num1 = RomanInteger.convertToArabic(operands[0]);
            num2 = RomanInteger.convertToArabic(operands[1]);
            isRoman = true;
        }
        else if (!RomanInteger.isRoman(operands[0]) && !RomanInteger.isRoman(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Введённые операнды должны быть либо оба арабскими, либо оба римскими");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Оба операнда должны быть от 1 до 10");
        }
        int arabic = calc(num1, num2, oper);
        if (isRoman) {
            if (arabic <= 0) {
                throw new Exception("Не бывает римских чисел меньше I");
            }
            result = RomanInteger.convertToRoman(arabic);
        } else {
            result = String.valueOf(arabic);
        }
        return result;
    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
        }
    static int calc(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }
}
class RomanInteger {
            static String [] romanArray = new String [] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                    "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                    "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                    "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                    "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                    "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                    "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                    "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                    "XCVIII", "XCIX", "C"};
            public static boolean isRoman (String value) {
                for (int x=0; x<romanArray.length; x++) {
                    if (value.equals(romanArray[x])) {
                        return true;
                    }
                }
                return false;
            }
            public static int convertToArabic (String roman) {
                for (int y=0; y<romanArray.length; y++) {
                    if (roman.equals(romanArray[y])) {
                        return y;
                    }
                }
                return -1;
            }
            public static String convertToRoman(int arabic) {
                return romanArray[arabic];
            }
}