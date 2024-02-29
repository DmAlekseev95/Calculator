import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите свой пример: ");
        String exp = scan.nextLine();
        char oper;
        String[] value;
        if (exp.contains(" + ")) {
            value = exp.split(" \\+ ");
            oper = '+';
        } else if (exp.contains(" - ")) {
            value = exp.split(" - ");
            oper = '-';
        } else if (exp.contains(" * ")) {
            value = exp.split(" \\* ");
            oper = '*';
        } else if (exp.contains(" / ")) {
            value = exp.split(" / ");
            oper = '/';
        } else{
            throw new Exception("Неверно введён операнд");
        }

        if (oper == '*' || oper == '/') {
            if (value[1].contains("\"")) throw new Exception ("Строку нельзя умножать или делить на другую строку");
        }
        for (int i = 0; i<value.length; i++){
            value[i] = value[i].replace("\"","");
        }
        if (value[0].length() > 10 || value[1].length() > 10) throw new Exception ("Превышена длина строки");
        if (Integer.parseInt(value[1])<1|| Integer.parseInt(value[1])>10) throw new Exception ("Введите число от 1 до 10");

        if (oper == '+'){
            printWithQuotes(value[0]+value[1]);
        } else if (oper=='*'){
            int multiplier = Integer.parseInt(value[1]);
            printWithQuotes(value[0].repeat(multiplier));
        } else if (oper == '-') {
            int index = value[0].indexOf(value[1]);
            if (index == -1) {
                printWithQuotes(value[0]);
            } else {
                String result = value[0].substring(0, index);
                result += value[0].substring(index + value[1].length());
                printWithQuotes(result);
            }
        } else {
            int shortValue = value[0].length()/Integer.parseInt(value[1]);
            String result = value[0].substring(0, shortValue);
            printWithQuotes(result);
        }

    }
    static void printWithQuotes (String text){
        if (text.length() > 41){
            System.out.println("\""+text.substring(0,40)+"...\"");
        } else{
            System.out.println("\""+text+"\"");
        }
    }
}
