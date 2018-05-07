import java.util.HashMap;

public class minWindow {


    public String findMinWindow(String s,String t)
    {
        HashMap<Character,Integer> myMap = new HashMap<Character, Integer>();

        for(char c: s.toCharArray())
        {
            myMap.put(c,0);
        }

        for(char c:t.toCharArray())
        {
            if(myMap.containsKey(c))
            {
                myMap.put(c,myMap.get(c) + 1);
            }
            else
            {
                return "";
            }
        }

        int start = 0,end=0,minLen=Integer.MAX_VALUE,minStart = 0,counter = t.length();

        while(end < s.length())
        {
            char c1 = s.charAt(end);
            if(myMap.get(c1) > 0)
            {
                counter--;
            }
            myMap.put(c1,myMap.get(c1) - 1);

            end++;

            while(counter == 0)
            {
                if(minLen > end-start)
                {
                    minLen = end-start;
                    minStart = start;
                }

                char c2 = s.charAt(start);
                myMap.put(c2,myMap.get(c2) + 1);
                if(myMap.get(c2)> 0)
                {
                    counter++;
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);

    }



    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        minWindow mw = new minWindow();


        String result = mw.findMinWindow(s, t);
        System.out.println(result);

    }
}
