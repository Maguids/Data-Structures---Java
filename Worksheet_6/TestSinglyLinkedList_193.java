
public class TestSinglyLinkedList_193 {
    public static void main(String[] args) {
        //TESTE 1
        SinglyLinkedList<Integer> lista_1 = new SinglyLinkedList<Integer>();
        lista_1.addLast(1);
        lista_1.addLast(2);
        lista_1.addLast(2);
        lista_1.addLast(2);
        lista_1.addLast(1);
        lista_1.addLast(3);
        lista_1.addLast(4);
        lista_1.addLast(2);
        lista_1.addLast(1);
        SinglyLinkedList<Integer> lista_2 = lista_1.copy();
        SinglyLinkedList<Integer> lista_3 = lista_1.copy();
        SinglyLinkedList<Integer> lista_4 = lista_1.copy();
        System.out.println("TESTE 1:");
        System.out.println("lista_1 = " + lista_1 + " [size] = " + lista_1.size());
        lista_1.removeAll(1);
        System.out.println("lista_1.removeAll(1) = " + lista_1 + " [size] = " + lista_1.size());
        System.out.println();

        //TESTE 2
        System.out.println("TESTE 2:");
        System.out.println("lista_2 = " + lista_2 + " [size] = " + lista_2.size());
        lista_2.removeAll(2);
        System.out.println("lista_2.removeAll(2) = " + lista_2 + " [size] = " + lista_2.size());
        System.out.println();
    
        //TESTE 3
        System.out.println("TESTE 3:");
        System.out.println("lista_3 = " + lista_3 + " [size] = " + lista_3.size());
        lista_3.removeAll(3);
        System.out.println("lista_3.removeAll(3) = " + lista_3 + " [size] = " + lista_3.size());
        System.out.println();

        //TESTE 4
        System.out.println("TESTE 4:");
        System.out.println("lista_4 = " + lista_4 + " [size] = " + lista_4.size());
        lista_4.removeAll(5);
        System.out.println("lista_4.removeAll(5) = " + lista_4 + " [size] = " + lista_4.size());
        System.out.println();

        //TESTE 5
        SinglyLinkedList<String> lista_5 = new SinglyLinkedList<String>();
        lista_5.addLast("cc");
        lista_5.addLast("cc");
        lista_5.addLast("cc");
        lista_5.addLast("cc");
        lista_5.addLast("cc");
        System.out.println("TESTE 5:");
        System.out.println("lista_5 = " + lista_5 + " [size] = " + lista_5.size());
        lista_5.removeAll("cc");
        System.out.println("lista_5.removeAll(''cc'') = " + lista_5 + " [size] = " + lista_5.size());
        System.out.println();
    }
}