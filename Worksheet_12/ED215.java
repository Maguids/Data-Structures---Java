import java.util.Scanner;

public class ED215 {

    static class Oferta implements Comparable<Oferta> {
        String n;   // nome
        int v;      // valor

        Oferta(String nome, int valor) {n = nome; v = valor;}
        public int compareTo(Oferta o) {return Integer.compare(v, o.v);}
        public String toString() {return -v + " " + n;}
    }


    public static void main(String[] args) {

        // inicializar o Scanner
        Scanner stdin = new Scanner(System.in);

        // criar MinHeap
        MinHeap<Oferta> list = new MinHeap<>(10000);


        int n = stdin.nextInt();
        while (stdin.hasNext()) {
            String s = stdin.next();
            if (s.equals("OFERTA")) {
                s = stdin.next();
                int v = stdin.nextInt();
                Oferta o = new Oferta(s, -v);
                list.insert(o);
            } else if (s.equals("VENDA")) {
                System.out.println(list.removeMin());
            }
        }

    }
}