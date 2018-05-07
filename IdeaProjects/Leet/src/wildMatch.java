public class wildMatch {

    public boolean isMatch(String s,String p)
    {
        boolean match[][] = new boolean[s.length()+1][p.length()+1];

        match[0][0] = true;

        for(int j=1;j<p.length()+1;j++)
        {
            if(p.charAt(j-1) == '*')
            {
                match[0][j] = match[0][j-1];
            }
        }


        for(int i=1;i<s.length()+1;i++)
        {
            for(int j=1;j<p.length()+1;j++)
            {
                if(p.charAt(i-1) == s.charAt(i-1) || p.charAt(i-1) == '?')
                {
                    match[i][j] = match[i-1][j-1];
                }
                else if(p.charAt(i-1) == '*')
                {
                    match[i][j] = match[i][j-1] || match[i-1][j];

                }
            }
        }

        return match[s.length()][p.length()];
    }

    public static void main(String[] args) {

        String s = "a";
        String p = "*ap";


        wildMatch w = new wildMatch();
        boolean ret = w.isMatch(s,p);

        System.out.println(ret);

    }
}
