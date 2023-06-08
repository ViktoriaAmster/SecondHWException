import java.util.NoSuchElementException;
import java.util.Scanner;

public class HWExceptions {
    public static void main(String[] args) {
        System.out.printf("вы ввели число %s", inputFloat());
        int[] secondTask = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byZero(secondTask);
        System.out.println(inputString());
    }

    //Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
    // необходимо повторно запросить у пользователя ввод данных.
    public static float inputFloat() {
        Scanner scan = new Scanner(System.in);
        float data;
        System.out.print("Введите дробное число: ");
        try {
            data = scan.nextFloat();
        } catch (NoSuchElementException e) {
            System.err.println(e + " Вы ввели не число");
            data = inputFloat();
        }
        return data;
    }

    //Задание 2. Если необходимо, исправьте данный код
    public static void byZero(int[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching eception: " + e);
        }
    }


    //Задание 4 Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static String inputString() {
        Scanner scan = new Scanner(System.in);
        String data;
        System.out.print("Введите непустую строку: ");
        try {
            data = scan.nextLine();
            if (data.isEmpty() || (data.replace(" ","").length() == 0))
                throw new RuntimeException(); //решила от себя добавить, что строка только с пробелами тоже пустая
            else return "ok";
        } catch (RuntimeException e) {
            System.err.println(e + " Пустую строку вводить нельзя!");
            data = inputString();
        }
        return data;
    }
}