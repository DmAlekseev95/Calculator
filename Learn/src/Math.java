public class Math {
    String result;
    String value0;
    String value1;
    public  Math(String value0, String value1) throws Exception {
        this.value0 = value0.replace("\"", "");
        this.value1 = value1.replace("\"", "");
        if (this.value0.length() > 10 || this.value1.length() > 10) throw new Exception("Превышена длина строки");
        if (!value0.contains("\"")) throw new Exception("Первым аргументом выражения должна быть строка");
    }
    public void print(){
        if (result.length() > 41) {
            System.out.println("\"" + result.substring(0, 40) + "...\"");
        } else {
            System.out.println("\"" + result + "\"");
        }
    }
    public String summ() {
        this.result = value0 + value1;
        return this.result;
    }
    public void subtract() {
        int index = value0.indexOf(value1);
        if (index == -1) {
            result = value0;
        } else {
            result = value0.substring(0, index);
            result += value0.substring(index + value1.length());
        }
    }
    public void multiply() throws Exception {
        if (value1.contains("\"")) throw new Exception("Строку нельзя умножать или делить на другую строку");
        int multiplier = Integer.parseInt(value1);
        if (multiplier < 1 || multiplier > 10) {
            throw new Exception("Введите число от 1 до 10");
        }else {
            result = value0.repeat(multiplier);
        }
    }
    public void div() throws Exception {
        if (value1.contains("\"")) throw new Exception("Строку нельзя умножать или делить на другую строку");
        int divider = Integer.parseInt(value1);
        int shortValue =value0.length()/divider;
        if (divider < 1 || divider > 10) {
            throw new Exception("Введите число от 1 до 10");
        }else {
            result = value0.substring(0, shortValue);
        }
    }
}
