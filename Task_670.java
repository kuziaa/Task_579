import java.util.Scanner;

public class Task_670 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 1, m = 1;
        String st_i = new String();
        while (m != n) {
            a += 1;
            int x = 0;
            if (a < 10) { //Если число меньше 10, то одинаковых цифр не будет
                m += 1;
            }else {
                st_i = String.valueOf(a);
                String[] list_i = st_i.split("");
                for (int i = 0; i < list_i.length - 1; i++) {
                    for (int j = i + 1; j < list_i.length; j++) {
                        if (Integer.parseInt(list_i[i]) == Integer.parseInt(list_i[j])) {
                            x = 1;
                            break;                //Если хоть одно число повторилось - выходим из цикла
                        }
                    }
                    if (x == 1) break;
                    if (i == list_i.length - 2) m += 1;
                }
            }
        }
        System.out.println(a);
    }
}
