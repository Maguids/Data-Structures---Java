import java.util.Scanner;
import java.util.LinkedList;

public class ED172 {

    public static void main(String[] args) {
        
        // inicializar o scanner
        Scanner stdin = new Scanner(System.in);

        // incializar o dicionário
        BSTMap<String,Integer> map = new BSTMap<String,Integer>();

        while (stdin.hasNext()) {
            String s = stdin.next();
            if (map.get(s) == null) {
                map.put(s, 1); 
            } else {map.put(s, map.get(s) + 1);}
        }

        LinkedList<String> keys = map.keys();
        for (String k : keys) {
            System.out.println(k + ": " + map.get(k));
        }

    }
}