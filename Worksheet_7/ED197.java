public class ED197 {

    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        MyQueue<Integer> r = new LinkedListQueue<Integer>();

        while (a.size() != 0 || b.size() != 0) {

            if (a.size() != 0 && b.size() != 0) {
                if (a.first() > b.first()) {
                    r.enqueue(b.dequeue()); 
                } else {
                    r.enqueue(a.dequeue()); 
                }
            } else if (a.size() != 0) {
                r.enqueue(a.dequeue()); 
            } else if (b.size() != 0) {
                r.enqueue(b.dequeue()); 
            }
        }
        return r;
    }

}