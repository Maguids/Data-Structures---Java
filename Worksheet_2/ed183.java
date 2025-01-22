import java.util.Scanner;

public class ed183 {

    static void media(int v[]){
        float soma = 0;
        for (int i = 0; i < v.length; i++){
            soma += v[i];
        }
        System.out.printf("%.2f\n", soma/v.length);
    }

    static void amplitude(int v[]){
        int n_menor = v[0];
        int n_maior = v[0];
        for (int i = 0; i < v.length; i++){
            if (v[i] < n_menor){
                n_menor = v[i];
            }
            if (v[i] > n_maior){
                n_maior = v[i];
            }
        }
        System.out.println(n_maior - n_menor);
   }

    public static void main(String[] args){

        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int v[] = new int[n];

        for (int i = 0; i < n; i++){
            v[i] = stdin.nextInt();
        }

        media(v);
        amplitude(v);

    }

}