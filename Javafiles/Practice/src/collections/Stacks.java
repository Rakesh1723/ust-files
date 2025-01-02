package collections;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(15);
        st.push(20);
        while(!st.isEmpty()){
//            int i = (int)st.peek();
//            System.out.println(i);
//            st.remove((Object)i);
            System.out.println(st.pop());
        }
    }
}
