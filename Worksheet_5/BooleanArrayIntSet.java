import java.util.Arrays;

class BooleanArrayIntSet implements IntSet {
    private int size;
    private boolean[] isElem;
    private int n;

    //construtor
    BooleanArrayIntSet(int x) {
        isElem = new boolean[x+1];
        size = 0;
        n = x;
        Arrays.fill(isElem, false);
    }

    public String toString() {
        String ans = "{";
        int counter = 0;
        for (int i = 0; i <= n; i++) {
            if (isElem[i] == true) {
                ans += i;
                counter += 1;
                if(counter != size) {ans += ",";}
            }
        }
        ans += "}";
        return ans;
    }

    public boolean contains(int x) {
        if (isElem[x] == true) {return true;}
        return false;
    }

    public boolean add(int x) {
        if (contains(x)) {return false;}
        isElem[x] = true;
        size++;
        return true;
    }

    public boolean remove(int x) {
        if (!contains(x)) {return false;}
        isElem[x] = false;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(isElem, false);
        size = 0;
    }

    public boolean equals(IntSet s) {
        if (size != s.size()) {return false;}
        int counter = 0;
        int pos = 0;
        while (counter != size) {
            if (isElem[pos] == true){
                if(s.contains(pos)){
                    counter += 1;
                } else {return false;}
            }
            pos += 1;
        }
        return true;
    }

    public IntSet intersection(IntSet s){
        IntSet novo = new BooleanArrayIntSet(n);
        for (int i = 0; i<=n; i++) {
            if(s.contains(i) && isElem[i] == true) {novo.add(i);}
        }
        return novo;
    }
}