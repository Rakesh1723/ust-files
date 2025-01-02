public class Strings {
    public static void main(String[] args) {

      //  System.out.println(Runtime.getRuntime().availableProcessors());

        String str="UST Global";

        int len=str.length();
        for(int i=0;i<len;i++)
            System.out.println(str.charAt(i));

        for(char s:str.toCharArray())
            System.out.println(s);

        // str.strip()-- same as trim.
        // concat doesn't modify original string but,it returns new one . Whereas  append modify the string.
        System.out.println(4+5+"6"+7+3);//9673 once string then all are treated as string. left 2 right.
    }
}
