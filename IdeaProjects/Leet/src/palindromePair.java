import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class palindromePair {

    public List<List<Integer>> genPairs(String[] s)
    {
        HashMap<String,Integer> myMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<s.length;i++)
        {
            myMap.put(s[i],i);
        }
        //for special cases if there is an empty string
        for(int i=0;i<s.length;i++)
        {
            if(myMap.containsKey(""))
            {
                int bIndex = myMap.get("");
                if(bIndex == i)
                {
                    continue;
                }
                else
                {
                   // res.add(bIndex,i);
                //    res.add(i,bIndex);
                }
            }
        }

        for(int i=0;i<s.length;i++)
        {
            String rev = revString(s);
            if(myMap.containsKey(rev))
            {
                int found = myMap.get(rev);
                if(found == i)
                {
                    continue;
                }
                else
                {
                    res.add(found,i);
                }
            }
        }

        //If part of the the strings joined are palindrome

        for(int i=0;i<s.length;i++)
        {
            String cur = s[i];
            for(int j=1;j<cur.length()-1;j++)
            {
                if(isPalindrome(cur.substring(0,j)))
                {
                    String cutString = revString(j);
                    if(myMap.containsKey(cutString))
                    {
                        int found = myMap.get(cutString);
                        if(found == i) continue;
                        res.add(found,i);
                    }
                }

                if(isPalindrome(cur.substring(j)))
                {
                    String cutString = revString(0,j);
                    if(myMap.containsKey(cutString))
                    {
                        int found = myMap.get(cutString);
                        if(found == i) continue;
                        res.add(found,i);
                    }
                }
            }
        }

    }

    public String revString(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    //for cases if there is a reverse of a string

    public boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;

        while(i<=j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return false;
    }


    public static void main(String[] args) {

        //String[] s = ["abcd","dcba","lls","s","sssll"];
        palindromePair p = new palindromePair();
        List<List<Integer>> res = p.genPairs(s);
        System.out.println(res);
    }
}
