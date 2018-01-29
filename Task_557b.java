import java.util.Scanner;

public class Task_557b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short m = in.nextShort();
        short n = in.nextShort();
        short a = in.nextShort();
        short b = in.nextShort();
        short p = in.nextShort();
        short[] str = new short[n];
        for (short i = 0; i < n; i++) {
            if (i == a - 1) {                    // В первом массиве нас интересует только строка с индексом a-1
                for (short j = 0; j < n; j++) {    // поэтому создадим одномерный массив с элементами этой строки
                    str[j] = in.nextShort();
                }
            }else {
                for (short j = 0; j < n; j++) {    // поэтому создадим одномерный массив с элементами этой строки
                    in.nextShort();
                }
                in.nextLine();
            }
        }
        short[][] masiv = new short[n][n];
        short h = 0;
        if (m == 1) {                           // Если по условию задан только 1 массив, сразу определяем
            h = str[b - 1];                     // интересующее нас значение
        }
        for (short k=1; k<m; k++) {
            for (short i = 0; i < n; i++) {
                for (short j = 0; j < n; j++) {
                    masiv[j][i] = in.nextShort();
                }
            }
            short[] s_out = new short[n];
            for (short i = 0; i < n; i++) {
                short summ = 0;
                for (short j = 0; j < n; j++) {
                    summ = (short) ((summ + str[j] * masiv[i][j]) % p);
                }
                s_out[i] = summ;
            }
            str = s_out;
            h = str[b-1];
        }
        System.out.print(h);
    }
}