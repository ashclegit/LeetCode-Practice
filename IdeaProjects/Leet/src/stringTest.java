import java.util.*;

public class stringTest {

    public List<String> generateValidStrings(String s)
    {
        List<String> res = new ArrayList<>();

        LinkedList<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        boolean found = false;

        queue.add(s);
        while(!queue.isEmpty())
        {
            String sub = queue.poll();
            if(isValid(sub))
            {
                res.add(sub);
                found = true;
            }

            if(found) continue;

            for(int i=0;i<sub.length();i++)
            {
                if(sub.charAt(i) != '(' && sub.charAt(i) != ')') continue;

                String trimmed = sub.substring(0,i) + sub.substring(i+1);
                System.out.println(trimmed);

                if(visited.contains(trimmed))
                {
                    visited.add(trimmed);
                    queue.add(trimmed);

                }
            }
        }

        return res;
    }

    public boolean isValid(String s)
    {
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')' && count-- == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        stringTest s = new stringTest();
        String test = "()())()";
        List<String> res = new ArrayList<>();
        res = s.generateValidStrings(test);
        System.out.println(res);
    }
}







