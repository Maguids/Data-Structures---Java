
public class ED196 {

    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        
        String keeper;
        String place;
        while(q.size() != 0) {
            keeper = q.dequeue();
            place = q.dequeue();
            if (place.equals("A")) {
                a.enqueue(keeper);
            } else if (place.equals("B")) {
                b.enqueue(keeper);
            } else if (place.equals("X")) {
                if (a.size() > b.size()) {b.enqueue(keeper);}
                if (a.size() < b.size()) {a.enqueue(keeper);}
            }
        }
    }

    public static void main(String[] args) {

        // Criacao da fila
        MyQueue<String> q = new LinkedListQueue<String>();
        MyQueue<String> a = new LinkedListQueue<String>();
        MyQueue<String> b = new LinkedListQueue<String>();

        String[] s = {"Luis", "B", "Pedro", "B", "Luisa", "X", "Joao", "X"};

        // Exemplo de insercao de elementos na fila
        for (int i=0; i < 8; i++)
            q.enqueue(s[i]); // insere i no final da fila

        process(q, a, b);
            
        System.out.println(q);
        System.out.println(a);
        System.out.println(b);
   }

}

