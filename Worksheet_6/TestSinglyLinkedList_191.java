
public class TestSinglyLinkedList_191 {
    public static void main(String[] args) {
        //TESTE 1
        SinglyLinkedList<Integer> lista_1 = new SinglyLinkedList<Integer>();
        lista_1.addLast(2);
        lista_1.addLast(4);
        lista_1.addLast(6);
        lista_1.addLast(8);
        System.out.println("TESTE 1:");
        System.out.println("lista_1 = " + lista_1 + " [size] = " + lista_1.size());
        lista_1.duplicate();
        System.out.println("lista_1_duplicada = " + lista_1 + " [size] = " + lista_1.size());
        System.out.println();

        //TESTE 2
        SinglyLinkedList<Character> lista_2 = new SinglyLinkedList<Character>();
        lista_2.addLast('a');
        lista_2.addLast('b');
        lista_2.addLast('c');
        lista_2.addLast('d');
        System.out.println("TESTE 2:");
        System.out.println("lista_2 = " + lista_2 + " [size] = " + lista_2.size());
        lista_2.duplicate();
        System.out.println("lista_2_duplicada = " + lista_2 + " [size] = " + lista_2.size());
        System.out.println();

        //TESTE 1
        SinglyLinkedList<Integer> lista_3 = new SinglyLinkedList<Integer>();
        System.out.println("TESTE 3:");
        System.out.println("lista_3 = " + lista_3 + " [size] = " + lista_3.size());
        lista_3.duplicate();
        System.out.println("lista_3_duplicada = " + lista_3 + " [size] = " + lista_3.size());
        System.out.println();
    }
}