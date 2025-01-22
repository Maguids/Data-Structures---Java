
public class ED195 {
    
    public static boolean balanced(String s) {

        int size = s.length();
        //System.out.println("size = " + size);
        //System.out.println("size/2 = " + size/2);
        if((size % 2) != 0) {return false;}
        
        MyStack<Character> keeper = new ArrayStack<Character>(size/2);
        for(int i = 0; i < size/2; i++) {
            char s_x = s.charAt(i);
            //System.out.println("char " + i + " = " + s_x);
            keeper.push(s_x);
        }
        System.out.println(keeper);

        int veracidade;
        int res_final = 1;

        for(int j = size/2; j < size; j++) {
            veracidade = 0;
            char s_i = s.charAt(j);
            char k_i = keeper.top();
            if(k_i =='('){
                if(s_i ==')') {
                    keeper.pop();
                    veracidade = 1;
                    System.out.println("caso 1");
                }
            } else if (k_i == '['){
                if(s_i == ']') {
                    keeper.pop();
                    veracidade = 1;
                    System.out.println("caso 2");
                }
            }

            if (veracidade == 0) {res_final = 0;}
        }

        if(res_final == 1) {return true;}
        return false;
    }

    public static void main(String[] args) {
        String s1 = "([()])";
        String s2 = "[()()]";
        String s3 = "(()]";
        String s4 = "[()[])";
        String s5 = "[()[]";

        //System.out.println("s1 = " + balanced(s1));
        System.out.println("s2 = " + balanced(s2));
        //System.out.println("s3 = " + balanced(s3));
        //System.out.println("s4 = " + balanced(s4));
        //System.out.println("s5 = " + balanced(s5));

    }
}