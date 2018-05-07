public class stringMatch {

    public boolean search(String s, String p)
    {
        int i=0;
        int j = 0;
        int k = 0;
        char[] sp = s.toCharArray();
        char[] pc = p.toCharArray();

        while(i<sp.length && j<pc.length)
        {
            if(sp[i] == pc[j])
            {
                i++;
                j++;
            }
            else
            {
                j=0;
                k++;
                i=k;
            }
        }

        if(j == pc.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        stringMatch ss = new stringMatch();
        boolean res = ss.search(str, subString);
        System.out.println(res);
    }
}
