
public class TestSinglyLinkedList_188 {
    public static void main(String[] args) {
        //TESTE 1
        SinglyLinkedList<Integer> lista_1 = new SinglyLinkedList<Integer>();
        lista_1.addLast(2);
        lista_1.addLast(4);
        lista_1.addLast(6);
        System.out.println(lista_1);
        System.out.println(lista_1.get(0));

        //TESTE 2
        SinglyLinkedList<Character> lista_2 = new SinglyLinkedList<Character>();
        lista_2.addLast('a');
        lista_2.addLast('b');
        lista_2.addLast('c');
        lista_2.addLast('d');
        System.out.println(lista_2);
        System.out.println(lista_2.get(3));

        //TESTE 3
        SinglyLinkedList<String> lista_3 = new SinglyLinkedList<String>();
        lista_3.addLast("estrutura");
        lista_3.addLast("de");
        lista_3.addLast("dados");
        System.out.println(lista_3);
        System.out.println(lista_3.get(3));

        //TESTE 4
        System.out.println(lista_3.get(-1));
    }
}