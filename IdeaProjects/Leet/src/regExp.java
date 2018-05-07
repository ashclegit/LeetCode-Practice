public class regExp {


    public boolean isMatch(String s,String p)
    {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];

        match[0][0] = true;

        for(int i=1;i<s.length()+1;i++)
        {
            for(int j=1;j<p.length()+1;j++)
            {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                {
                    match[i][j] = match[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*')
                {
                    match[i][j] = match[i][j-2] || match[i-1][j];
                }
            }
        }

        return match[s.length()][p.length()];
    }

    public static void main(String[] args) {

        String s = "a*b";
        String p = "b";

        regExp re = new regExp();
        boolean ret = re.isMatch(s,p);
        System.out.println(ret);

    }
}
