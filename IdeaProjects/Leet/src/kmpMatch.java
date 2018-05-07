public class kmpMatch {

    public int[] computeTemporaryArray(char[] pattern)
    {

        int[] lps = new int[pattern.length];
        int index = 0;

        for(int i=1;i<pattern.length;)
        {
            if(pattern[index] == pattern[i])
            {
                lps[index] = index + 1;
                index++;
                i++;
            }
            else
            {
                if(index != 0)
                {
                    index = lps[index - 1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }


    public boolean kmpSearch(char[] s,char[] p)
    {
        int[] lps = computeTemporaryArray(p);
        int i =0;
        int j=0;

        while(i <= s.length && j <= p.length)
        {
            if(s[i] == p[j])
            {
                i++;
                j++;
            }
            else
            {
                if(j != 0)
                {
                    j = lps[i-1];
                }
                else
                {
                    i++;
                }
            }
        }

        if(j == p.length)
        {
            System.out.println("true");
            return true;
        }
        else
        {
            System.out.println("false");
            return false;
        }

    }

    public static void main(String[] args) {

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        kmpMatch ss = new kmpMatch();
        boolean result = ss.kmpSearch(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }
}
