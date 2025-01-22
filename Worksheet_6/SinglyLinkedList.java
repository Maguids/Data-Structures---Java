
public class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    //construtor
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    //Retorna o tamanho da lista
    public int size(){
        return size;
    }

    //Devolve 1 se a lista estiver vazia e 0 em caso contrário
    public boolean isEmpty() {
        return (size == 0);
    }

    //Adiciona v ao inicio da lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    //Adiciona v ao fim da lista
    public void addLast(T v) {
        Node <T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(newNode);
        }
        size++;
    }

    //Devolve o primeiro valor da lista (v) ou null se a lista for vazia
    public T getFirst() {
        if(isEmpty()) {
            return null;
        }
        return first.getValue();
    }

    //Retorna o último valor da lista ou null se a lista for vazia
    public T getLast() {
        if(isEmpty()) {
            return null;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            return cur.getValue();
        }
    }

    //Remove o primeiro elemento da lista ou não faz nada se for vazia
    public void removeFirst() {
        if (isEmpty()) return;
        first = first.getNext();
        size--;
    }

    //Remove o último elemento da lista ou não faz nada se for vazia
    public void removeLast() {
        if (isEmpty()) return;
        if (size == 1) {
            first = null;
        } else {
            Node<T> cur =  first;
            for (int i = 0; i < size-2; i++) {
                cur = cur.getNext();
            }
            cur.setNext(null);
        }
        size--;
    }

    //converter a lista para uma String
    public String toString() {
        String ans = "{";
        Node<T> cur = first;
        while (cur != null) {
            ans += cur.getValue();
            cur = cur.getNext();
            if (cur != null) {ans += ",";}
        }
        ans += "}";
        return ans;
    }

    //MOOSHAK 188
    //obter o valor numa dada posição
    public T get(int pos) {
        if (pos < 0) {return null;}
        if (size <= pos) {return null;}
        
        Node<T> cur = first;
        for (int i = 0; i != pos; i++) {
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    //MOOSHAK 189
    //remove e devolve o elemento na posição pos
    public T remove(int pos) {
        T keeper;
        if (pos < 0) {return null;}
        if (size <= pos) {return null;}
        if (pos == 0) {
            keeper = first.getValue();
            first = first.getNext();
            size--;
            return keeper;
        } else {
            Node<T> anterior = first;
            Node<T> cur = first.getNext();
            for (int i = 1; i != pos; i++) {
                anterior = cur;
                cur = cur.getNext();
            }
            keeper = cur.getValue();
            anterior.setNext(cur.getNext());
            size--;
            return keeper;
        }
    }

    //MOOSHAK 190
    //cria e devolve a cópia de uma lista que é a cópia exata da lista para a qual foi chamado o método
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> nova_lista = new SinglyLinkedList<T>();

        Node<T> cur = first;
        T keeper;
        while (cur.getNext() != null) {
            keeper = cur.getValue();
            nova_lista.addLast(keeper);
            cur = cur.getNext();
        }
        keeper = cur.getValue();
        nova_lista.addLast(keeper);

        return nova_lista;
    }

    //MOOSHAK 191
    //duplica cada elemento da lista sem criar uma nova lista
    public void duplicate() {
        T keeper;
        if(size == 0) {return;}

        Node<T> anterior = first;
        Node<T> cur = first.getNext();
        while (cur != null){
            keeper = anterior.getValue();
            Node<T> new_node = new Node<T>(keeper, cur);
            anterior.setNext(new_node);
            size++;
            anterior = cur;
            cur = cur.getNext();
        }
        keeper = anterior.getValue();
        Node<T> new_node = new Node<T>(keeper, cur);
        anterior.setNext(new_node);
        size++;
        return;
    }

    //MOOSHAK 192
    //conta e devolve o número de ocorrências do valor value
    public int count(T value) {
        T keeper;
        int counter = 0;

        Node<T> cur = first;
        while (cur != null) {
            keeper = cur.getValue();
            if (keeper.equals(value)) {counter++;}
            cur = cur.getNext();
        }
        return counter;
    }

    //MOOSHAK 193
    //remove da lista todas as ocurrências do valor value
    public void removeAll(T value) {
        if (size == 0) {return;}

        T keeper = first.getValue();
        while (keeper.equals(value)) {
            size--;
            first = first.getNext();
            if (first == null) {return;}
            keeper = first.getValue();
        }

        Node<T> anterior = first;
        Node<T> cur = first.getNext();

        while (cur != null) {
            keeper = cur.getValue();
            if (keeper.equals(value)) {
                size--;
                cur = cur.getNext();
                anterior.setNext(cur);
            } else {
                anterior = cur;
                cur = cur.getNext();
            }
        }
    }

}