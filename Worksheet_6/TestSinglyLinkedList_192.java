
public class TestSinglyLinkedList_192 {
    public static void main(String[] args) {
        //TESTE 1
        SinglyLinkedList<Integer> lista_1 = new SinglyLinkedList<Integer>();
        lista_1.addLast(42);
        lista_1.addLast(200);
        lista_1.addLast(42);
        lista_1.addLast(9999);
        lista_1.addLast(42);
        lista_1.addLast(200);
        lista_1.addLast(42);
        System.out.println("TESTE 1:");
        System.out.println("lista_1 = " + lista_1 + " [size] = " + lista_1.size());
        System.out.println("lista_1.count(42) = " + lista_1.count(42));
        System.out.println("lista_1.count(200) = " + lista_1.count(200));
        System.out.println("lista_1.count(9999) = " + lista_1.count(9999));
        System.out.println("lista_1.count(1) = " + lista_1.count(1));
        System.out.println();

        //TESTE 2
        SinglyLinkedList<String> lista_2 = new SinglyLinkedList<String>();
        lista_2.addLast("cc");
        lista_2.addLast("cc");
        lista_2.addLast("cc");
        lista_2.addLast("cc");
        lista_2.addLast("cc");
        System.out.println("TESTE 2:");
        System.out.println("lista_2 = " + lista_2 + " [size] = " + lista_2.size());
        System.out.println("lista_2.count(''cc'') = " + lista_2.count("cc"));
        System.out.println();
    }
}