import java.util.Scanner;

public class ED198 {

    static void hipotese_1 (int n, int v[]) {
        int maxSoFar = v[0];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += v[k];
                }
                //System.out.println("Soma entre " + i + " e " + j + " = " + sum);
                if (sum > maxSoFar) {maxSoFar = sum;}
            }
        }
        System.out.println(maxSoFar);
    }

    static void hipotese_2 (int n, int v[]) {
        int maxSoFar = v[0];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += v[j];
                //System.out.println("Soma entre " + i + " e " + j + " = " + sum);
                if (sum > maxSoFar) {maxSoFar = sum;}
            }
        }
        System.out.println(maxSoFar);
    }

    static void hipotese_3 (int n, int v[]) {
        int best[] = new int[n];
        best[0] = v[0];
        int maxSoFar = best[0];
        for (int i = 1; i < n; i++) {
            if (best[i-1] > 0) {
                best[i] = best[i-1] + v[i];
                if (maxSoFar < best[i]) {maxSoFar = best[i];}
            } else {
                best[i] = v[i];
                if (maxSoFar < best[i]) {maxSoFar = best[i];}
            }
        }
        System.out.println(maxSoFar);
    }


    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int[] v = new int[n];

        for(int i = 0; i < n; i++) {
            v[i] = stdin.nextInt();
        }

        hipotese_3(n, v);
    }
}