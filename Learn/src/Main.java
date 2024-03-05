import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите свой пример: ");
        String exp = scan.nextLine();
        char oper;
        String[] value;
        Math a = null;
        if (exp.contains(" + ")) {
            value = exp.split(" \\+ ");
            if (!value[1].contains("\"")) throw new Exception("При сложении оба аргумента должны быть строками");
            a = new Math(value[0], value[1]);
            a.summ();
            oper = '+';
        } else if (exp.contains(" - ")) {
            value = exp.split(" - ");
            if (!value[1].contains("\"")) throw new Exception("При сложении оба аргумента должны быть строками");
            a = new Math(value[0], value[1]);
            a.subtract();
            oper = '-';
        } else if (exp.contains(" * ")) {
            value = exp.split(" \\* ");
            a = new Math(value[0], value[1]);
            a.multiply();
            oper = '*';
        } else if (exp.contains(" / ")) {
            value = exp.split(" / ");
            a = new Math(value[0], value[1]);
            a.div();
            oper = '/';
        } else {
            throw new Exception("Неверно введён операнд");
        }
        a.print();
    }
}