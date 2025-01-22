// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Implementacao do TAD Fila usando lista duplamente ligada
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class LinkedListQueue<T> implements MyQueue<T> {
   private DoublyLinkedList<T> list;

   LinkedListQueue() { list = new DoublyLinkedList<T>();}
   
   public void enqueue(T v) { list.addLast(v); }   
   public T dequeue() {
      T ans = list.getFirst();
      list.removeFirst();
      return ans;
   }
   public T first() { return list.getFirst();}
   public int size() {return list.size();}
   public boolean isEmpty() {return list.isEmpty();}

   public String toString() {return list.toString();}
}