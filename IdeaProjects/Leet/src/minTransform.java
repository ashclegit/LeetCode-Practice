import java.util.*;

public class minTransform {

    public int minFindLength(String beginWord,String endWord, List<String> wordList)
    {

        Set<String> dict = new HashSet<String>(wordList);
        Queue<String> queue = new LinkedList<String>();
        int level = 1;
        queue.add(beginWord);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                char[] cur = queue.poll().toCharArray();
                for(int i =0;i<cur.length;i++)
                {
                    char tmp = cur[i];
                    for(char ch='a' ;ch <='z';ch++)
                    {
                        cur[i] = ch;
                        String dest = new String(cur);
                        if(dict.contains(dest)) {
                            if (dest.equals(endWord)) {
                                return level + 1;
                            }
                            queue.add(dest);
                            dict.remove(dest);
                        }
                    }
                    cur[i] = tmp;
                }

            }
            level++;
        }

        return level;

    }

    public static void main(String[] args) {

        minTransform mt = new minTransform();

        int res = mt.minFindLength(start,end,wordList);

    }
}
