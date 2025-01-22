
class ArrayListIntSet implements IntSet  {
    private int size;
    private int elem[];

    //construtor
    ArrayListIntSet(int maxSize) {
        size = 0;
        elem = new int[maxSize];
    }

    public boolean contains(int x) {
        for(int i = 0; i < size; i++) {
            if (x == elem[i]) {return true;}
        }
        return false;
    }

    public boolean add(int x) {
        if (contains(x)) {return false;}
        elem[size] = x;
        size++;
        return true;
    }

    public boolean remove(int x) {
        if (!contains(x)) {return false;}
        for (int i = 0; i < size; i++) {
            if (x == elem[i]) {
                size--;
                elem[i] = elem[size]; 
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public String toString() {
        String ans = "{";
        for (int i = 0; i < size; i++) {
            ans += elem[i];
            if(i != size-1) {ans += ",";}
        }
        ans += "}";
        return ans;
    }

    public boolean equals(IntSet s) {
        if (size != s.size()) {return false;}
        for (int i = 0; i < size; i++) {
            if(s.contains(elem[i])) {
            } else {return false;}
        }
        return true;
    }

    public IntSet intersection(IntSet s) {
        IntSet novo = new ArrayListIntSet(100);
        for(int i = 0; i < size; i++) {
            if (s.contains(elem[i])) {
                novo.add(elem[i]);
            }
        }
        return novo;
    }
}