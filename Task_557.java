import java.util.Scanner;

public class Task_557 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int p = in.nextInt();
        int[] str = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == a - 1) {                    // В первом масиве нас интерисует только строка с индексом a-1
                for (int j = 0; j < n; j++) {    // поэтому создадим одномерный масил с элементами этой строки
                    str[j] = in.nextInt();
                }
            }else {
                for (int j = 0; j < n; j++) {
                    in.nextInt();                // Все остальные элементы первого масива не сохраняем
                }
            }
        }
        int[][] masiv = new int[n][n];
        int h = 0;
        if (m == 1) {                           // Если по условию задан только 1 масив, сразу определяем
            h = str[b - 1];                     // интересующее нас значение
        }
        for (int k=1; k<m; k++){
            for (int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    masiv[i][j] = in.nextInt();
                }
            }
            if (k != m - 1) {
                str = f(str, masiv, p);         // Премножаем все масивы от первого до предпоследнего
            } else{
                for (int i = 0; i < n; i++) {
                    h += str[i] * masiv[i][b - 1];  // В последнем масиве нас интересует только столбец b-1
                }
                h = h % p;
            }
        }
        System.out.print(h);
    }
    public static int[] f(int[] s, int[][] m, int p) {
        int n = s.length;
        int[] s_out = new int[n];
        for (int i=0; i<n; i++) {
            int summ = 0;
            for(int j=0; j<n; j++) {
                summ += s[j] * m[j][i];
            }
            s_out[i] = summ % p;
        }
        return s_out;
    }
}

