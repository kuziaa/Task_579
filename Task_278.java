import java.util.Scanner;

public class Task_278 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line_1 = in.nextLine();
        String line_2 = in.nextLine();
        char[] list_1 = line_1.toCharArray();
        char[] list_2 = line_2.toCharArray();
        int n = list_1.length;
        int m = list_2.length;                // Если первая последовательность длиннее второй,
        if (n > m) System.out.println("NO");  // то подпоследовательность существовать не может
        else {
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                if (y == m) x = 1;
                if (x == 1) break;
                for (int j = y; j < m; j++) {
                    if (list_1[i] == list_2[j]) {
                        y = j + 1;
                        break;
                    }
                    if (j == m - 1) x = 1;
                }
            }
            if (x == 1) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
