import java.util.Scanner;

public class Task_579 {
// Решение задачи №579 с сайта http://acmp.ru
    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);
        int kol = in.nextInt();
        int[] int_nums = new int[kol];
        int summ = 0, x = 0, y = 0;
        String more_zero = new String();
        String less_zero = new String();
        for (int i = 0; i < kol; i++) {
            int_nums[i] = in.nextInt();
            summ += int_nums[i];              //Определим сумму всех элементов.
            if (int_nums[i] > 0) {            //Если сумма положительных больше
                more_zero += (String.valueOf(i + 1) + " ");
                x += 1;
            }
            if (int_nums[i] < 0) {            //Если модуль суммы отрицательных больше
                less_zero += (String.valueOf(i + 1) + " ");
                y += 1;
            }
        }
        if (summ >= 0) {
            if (more_zero.length() == 0) {    //Если сумма всех чисел равна нулю
                System.out.print("0\n");
            } else {
                System.out.print(x + "\n" + more_zero);
            }
        } else {
            System.out.print(y + "\n" + less_zero);
        }
    }
}
