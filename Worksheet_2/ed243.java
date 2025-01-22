import java.util.Scanner;

public class ed243 {

    static int verificacao (int[] ingredientes, int n_ingredientes, int[] condimentos,int n_condimentos){
        for (int i = 0; i < n_ingredientes; i++){
            for (int j = 0; j < n_condimentos; j++)
                if (ingredientes[i] == condimentos[j]){
                    return 0;
                }
        }
        return 1;
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        int n_ingredientes = stdin.nextInt();
        int[] ingredientes = new int[n_ingredientes];

        for (int i = 0; i < n_ingredientes; i++){
            ingredientes[i] = stdin.nextInt();
        }

        int n_pizzas = stdin.nextInt();
        int counter = 0;

        for (int j = 0; j < n_pizzas; j++){
            int n_condimentos = stdin.nextInt();
            int[] condimentos = new int[n_condimentos];

            for (int k = 0; k < n_condimentos; k++){
                condimentos[k] = stdin.nextInt();
            }
            counter += verificacao(ingredientes, n_ingredientes, condimentos, n_condimentos);
        }

        System.out.println(counter);
    }
}