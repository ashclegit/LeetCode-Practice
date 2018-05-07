public class lonCommonSub {


    public int findMaxLength(String s, String t)
    {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        int max = 0;
        int[][] dp = new int[sc.length+1][tc.length+1];

        for(int i=1;i<=sc.length;i++)
        {
            for(int j=1;j<=tc.length;j++)
            {
                if(sc[i-1] == tc[j-1])
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                if(dp[i][j] > max)
                {
                    max  = dp[i][j];
                }
            }
        }

        return max;
    }



    public static void main(String[] args) {

        String str = "abcdef";
        String t = "acbcf";
        lonCommonSub lc =  new lonCommonSub();
        int result = lc.findMaxLength(str,t);
        System.out.println(result);


    }
}
