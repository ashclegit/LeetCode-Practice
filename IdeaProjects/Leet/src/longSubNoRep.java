import java.util.HashMap;

public class longSubNoRep {

    public int findNoRep(String s)
    {

        HashMap<Character,Integer> myMap = new HashMap<Character, Integer>();

        int j = 0;
        int max = 0;

        for(int i=0;i<s.length();i++)
        {
            if(myMap.containsKey(s.charAt(i)))
            {
                j = Math.max(j,myMap.get(s.charAt(i)) + 1);
            }
            myMap.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {


        String str = "abcabcbb";
        longSubNoRep lr = new longSubNoRep();
        int result =  lr.findNoRep(str);
        System.out.println(result);

    }
}


//   a bcabcbb