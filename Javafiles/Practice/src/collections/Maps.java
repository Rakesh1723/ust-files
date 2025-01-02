package collections;

import java.util.HashMap;

public class Maps {
    public static void main(String[] args) {
        String str="HelLo";
        HashMap<Character,Integer> hs=new HashMap<>();
        for(char c:str.toCharArray())
        {
            hs.put(Character.toLowerCase(c), hs.getOrDefault(Character.toLowerCase(c),0)+1);
        }
        for(char i:hs.keySet())
        {
            System.out.println(i+" "+hs.get(i));
        }

    }
}
