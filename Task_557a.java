import java.util.Scanner;

public class Task_557a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int h = n;
        for (int i = 1; i < 9; i++) {
            if (n <= Math.pow(2, i)) {
                h = (int) Math.pow(2, i);
                break;
            }
        }
        int a = in.nextInt();
        int b = in.nextInt();
        int p = in.nextInt();
        int[][] massiv_1 = new int[h][h];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == a - 1) {
                    massiv_1[0][j] = in.nextInt();
                }else {
                    in.nextInt();
                }
            }
        }
        int[][] massiv_2 = new int[h][h];
        int x = massiv_1[0][b-1];
        int z = 0;
        for (int k = 1; k < m; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    massiv_2[i][j] = in.nextInt();
                }
            }
            if (n == 1) {
                x = x * massiv_2[0][0] % p;
            }else {
                if (k != m - 1){
                    massiv_1 = f_umn(massiv_1, massiv_2);
                    for (int j = 0; j < n; j++) {
                        massiv_1[0][j] = massiv_1[0][j] % p;
                    }
                }else{
                    for (int j = 0; j < n; j++) {
                        z = (z + massiv_1[0][j] * massiv_2[j][b-1] % p) % p;
                    }
                }
            }
        }
        if (m == 1 | n == 1) {
            System.out.println(x);
        } else {
            System.out.println(z);
        }
    }

    public static int[][] f_umn(int[][] m_1, int[][] m_2) {
        if(m_1.length > 2) {
            int n = m_1.length;
            int[][] a = new int[n/2][n/2];
            int[][] b = new int[n/2][n/2];
            int[][] e = new int[n/2][n/2];
            int[][] f = new int[n/2][n/2];
            int[][] g = new int[n/2][n/2];
            int[][] l = new int[n/2][n/2];
            for (int j = 0; j < n; j++) {
                if (j < n/2) {
                    a[0][j] = m_1[0][j];
                }else {
                    b[0][j-n/2] = m_1[0][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++){
                    if (i < n / 2) {
                        if(j < n / 2) {
                            e[i][j] = m_2[i][j];
                        }else {
                            f[i][j-n/2] = m_2[i][j];
                        }
                    }else {
                        if(j < n / 2) {
                            g[i-n/2][j] = m_2[i][j];
                        }else {
                            l[i-n/2][j-n/2] = m_2[i][j];
                        }
                    }
                }
            }
            int[][] p_1 = f_umn(a, e);
            int[][] p_2 = f_umn(b, l);
            int[][] p_3 = f_umn(b, g);
            int[][] p_4 = f_umn(a, f);
            int[][] c_1 = f_sum(p_1, p_3);
            int[][] c_2 = f_sum(p_4, p_2);
            int[][] m_3 = new int[n][n];
            for (int j = 0; j < n; j++) {
                if (j < n / 2) {
                    m_3[0][j] = c_1[0][j];
                } else {
                    m_3[0][j] = c_2[0][j - n / 2];
                }
            }
            return m_3;
        }else {
            int[][] m_3 = new int[2][2];
            m_3[0][0] = m_1[0][0] * m_2[0][0] + m_1[0][1] * m_2[1][0];
            m_3[0][1] = m_1[0][0] * m_2[0][1] + m_1[0][1] * m_2[1][1];
            return m_3;
        }
    }

    public static int[][] f_sum(int[][] m_1, int m_2[][]) {
        int n = m_1.length;
        int[][] m_3 = new int[n][n];
        for (int j = 0; j < n; j++) {
            m_3[0][j] = m_1[0][j] + m_2[0][j];
        }
        return m_3;
    }
}