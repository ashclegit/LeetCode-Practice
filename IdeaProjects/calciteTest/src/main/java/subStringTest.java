import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;


public class subStringTest {

    public int getID(String s){
        int[] counter   =   new int[26];
        for(char ch : s.toCharArray()){
            counter[ch - 'a']++;
        }

        return Arrays.hashCode(counter);    //use the counter array's hash code as this anagram's ID
    }

    //solution takes 18ms
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups   =   new ArrayList<>();
        HashMap<Integer, List<String>> anagramMap   =   new HashMap<>();

        for(String word : strs){
            int id   =   getID(word);   //unique for each anagram
            List<String> group  =   anagramMap.get(id);

            if(null == group){
                group  =   new ArrayList();
                anagramMap.put(id, group);

            }

            group.add(word);
        }

        groups.addAll(anagramMap.values());

        return groups;
    }



    public static void main(String[] args) {

        String[] sArray = {"ate","ten","net"};

        subStringTest st = new subStringTest();
        System.out.println(st.groupAnagrams(sArray));

    }
}
