import java.util.Scanner;

public class ED164 {

    public static void main(String[] args) {
        // Criar o Scanner
        Scanner stdin = new Scanner(System.in);

        // Criacao da Arvore (no enunciado diz que são Strings)
        BSTree<String> t = new BSTree<String>();

        // obter o número de palavras
        int n = stdin.nextInt();
        for (int i = 0; i < n; i++) {
            String s = stdin.next();
            t.insert(s);
        }
        System.out.println(t.numberNodes());
    }
}