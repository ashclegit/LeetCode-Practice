public class longSequence {

    public String findMaxLength(String s, String t)
    {
        char[] sp = s.toCharArray();
        char[] tp = t.toCharArray();

        int[][] dp = new int[tp.length+1][sp.length+1];


        for(int i=1;i<=tp.length;i++)
        {
            for(int j=1;j<=sp.length;j++)
            {
                if(sp[j-1] == tp[i-1] && (dp[i-1][j-1] > 0 || i == 1))
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else if (dp[i][j-1] > 0)
                {
                    dp[i][j] = dp[i][j-1] + 1;
                }

                System.out.println(dp[i][j]);
            }


        }



        int minVal = Integer.MAX_VALUE;
        int index = -1;

        for(int i=0;i<sp.length;i++)
        {
            if(dp[tp.length][i] != 0 && minVal > dp[tp.length][i])
            {
                minVal = dp[tp.length][i];
                index = i;
            }
        }


        return minVal == Integer.MAX_VALUE ? ""  : s.substring(index - minVal,index);
    }

    public static void main(String[] args) {


        String str = "abcdebdde";
        String t = "bde";
        longSequence ls =  new longSequence();
        String result = ls.findMaxLength(str,t);
        System.out.println(result);

    }
}
