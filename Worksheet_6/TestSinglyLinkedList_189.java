
public class TestSinglyLinkedList_189 {
    public static void main(String[] args) {
        //TESTE 1
        SinglyLinkedList<Integer> lista_1 = new SinglyLinkedList<Integer>();
        lista_1.addLast(2);
        lista_1.addLast(4);
        lista_1.addLast(6);
        System.out.println("TESTE 1:");
        System.out.println(lista_1);
        lista_1.remove(0);
        System.out.println(lista_1);
        System.out.println();

        //TESTE 2
        SinglyLinkedList<Character> lista_2 = new SinglyLinkedList<Character>();
        lista_2.addLast('a');
        lista_2.addLast('b');
        lista_2.addLast('c');
        lista_2.addLast('d');
        System.out.println("TESTE 2:");
        System.out.println(lista_2);
        lista_2.remove(3);
        System.out.println(lista_2);
        System.out.println();

        //TESTE 3
        SinglyLinkedList<String> lista_3 = new SinglyLinkedList<String>();
        lista_3.addLast("estrutura");
        lista_3.addLast("de");
        lista_3.addLast("dados");
        System.out.println("TESTE 3:");
        System.out.println(lista_3);
        lista_3.remove(3);
        System.out.println(lista_3);
        System.out.println();

        //TESTE 4
        System.out.println("TESTE 4:");
        System.out.println(lista_3);
        lista_3.remove(-1);
        System.out.println(lista_3);
        System.out.println();

        //OUTROS TESTES
        SinglyLinkedList<Integer> lista = new SinglyLinkedList<Integer>();
        lista.addLast(2);
        lista.addLast(4);
        lista.addLast(6);
        lista.addLast(8);
        lista.addLast(10);
        System.out.println("OUTROS TESTES:");
        System.out.println("list = " + lista);
        System.out.println("list.remove(-2) = " + lista.remove(-2));
        System.out.println("Depois do remove, list = " + lista + " [size = " + lista.size() + "]");
        System.out.println();
    }
}