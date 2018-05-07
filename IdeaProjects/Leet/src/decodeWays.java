public class decodeWays {

    public int decode(String s)
    {
        if(s.length() == 0){
            return 0;
        }

        int dp[] = new int[s.length()];
        dp[0] = s.charAt(0) > '0' ? 1:0;

        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i) > '0')
            {
                dp[i] = dp[i] + 1;
            }
            if(s.charAt(i-1) > '0' && ((s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0' <= 26 ))
            {
                dp[i] += i-2 > 0 ? i-2 : 1;
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {

    }
}
