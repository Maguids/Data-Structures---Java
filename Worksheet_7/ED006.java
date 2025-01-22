import java.util.Scanner;

public class ED006 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        stdin.nextLine(); //Consumir a quebra de linha

        while (n != 0) {
            String[] frase;
            int n_pessoas;

            //saber quantas palavras tem a frase
            frase = stdin.nextLine().split(" ");
            n_pessoas = stdin.nextInt();

            //obter os participantes e colocá-los na lista
            String[] pessoas = new String[n_pessoas];
            CircularLinkedList<String> lista_pessoas = new CircularLinkedList<String>();
            for(int m = 0; m < n_pessoas; m++) {
                pessoas[m] = stdin.next();
                lista_pessoas.addLast(pessoas[m]);
            }

            //remover quem se livrou
            while (lista_pessoas.size() != 1) {
                for(int g = 0; g < frase.length-1; g++){
                    lista_pessoas.rotate();
                }
                lista_pessoas.removeFirst();
            }

            //ver o resultado
            String ans = "Carlos";
            String resultado = lista_pessoas.getFirst();
            if (ans.equals(resultado)) {
                System.out.println("O Carlos nao se livrou");
            } else {
                System.out.println("O Carlos livrou-se (coitado do "+resultado+"!)");
            }

            n -= 1;
            if (n != 0) {stdin.nextLine();}
        }

    }
}