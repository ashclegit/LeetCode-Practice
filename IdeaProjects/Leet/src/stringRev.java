public class stringRev {


    public String revString(String s)
    {
        char[] str = new char[s.length()];

        for(int i=0;i<str.length;i++)
        {
            str[i] = s.charAt(6-i-1);
            System.out.println(str[i]);
        }

        String res = new String(str);

        System.out.println(res);
        return res;
    }




    public static void main(String[] args) {

        String s = "ashwin";
        stringRev sr =  new stringRev();
        String res = sr.revString(s);
        System.out.println(res);

    }
}
