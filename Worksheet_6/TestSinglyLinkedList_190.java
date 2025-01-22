
public class TestSinglyLinkedList_190 {
    public static void main (String[] args) {
        //TESTE 1
        SinglyLinkedList<Integer> lista_1 = new SinglyLinkedList<Integer>();
        lista_1.addLast(2);
        lista_1.addLast(4);
        lista_1.addLast(6);
        lista_1.addLast(8);
        System.out.println("TESTE 1:");
        System.out.println("lista_1 = " + lista_1);
        SinglyLinkedList<Integer> lista_1_copy = lista_1.copy();
        System.out.println("lista_1_copy = " + lista_1_copy);
        lista_1.addLast(10);
        System.out.println("Alterações:");
        System.out.println("nova lista_1 = " + lista_1);
        System.out.println("'nova' lista_1_copy = " + lista_1_copy);
        System.out.println();
    }
}