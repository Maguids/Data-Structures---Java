import java.util.Scanner;

public class ED165 {

    public static void main(String[] args) {
        //incializar o Scanner
        Scanner stdin = new Scanner(System.in);
        BSTree<Integer> list = new BSTree<Integer>();

        // guardar os numeros recebidos num array
        int n = stdin.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {numbers[i] = stdin.nextInt();}

        // guardar todas as somas de 2 números numa BSTree
        for (int a = 0; a < n; a++) {
            for (int b = a; b < n; b++) {
                list.insert(numbers[a] + numbers[b]);
            }
        }

        // obter as 'perguntas'
        int n2 = stdin.nextInt();
        for(int j = 0; j < n2; j++) {
            int x = stdin.nextInt();
            if (list.contains(x) == true) {System.out.println(x + ": " + "sim");}
            else {System.out.println(x + ": " + "nao");}
        } 

    }

}