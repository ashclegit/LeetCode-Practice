public class stringTest {

    public String getLongestPalSub(String test)
    {
        int n = test.length();
        String res = null;
        boolean dp[][] = new boolean[n][n];

        for(int i=n-1;i>=0;i--)
        {
            for(int j=i;j<n;j++)
            {
                dp[i][j] = test.charAt(i) == test.charAt(j) && (j-i < 3 || dp[i+1][j-1]);
                if(dp[i][j] && (res == null || j-i+1 < n ))
                {
                    res = test.substring(i,j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "babad";

        stringTest t = new stringTest();
        String result = t.getLongestPalSub(test);
        System.out.println(result);
    }
}
