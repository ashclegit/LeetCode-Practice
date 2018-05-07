public class shortPal {


    public String getShortPal(String s)
    {
        String temp = s+"_"+new StringBuilder(s).reverse().toString();
        System.out.println(temp);
        int[] tempTable = getTable(temp);

        return new StringBuilder(s.substring(tempTable[tempTable.length - 1])).reverse().toString() + s;

    }

    public int[] getTable(String temp)
    {
        int index = 0;
        int[] ls = new int[temp.length()];
        ls[0] = 0;
        for(int i=1;i<temp.length();)
        {
            if(temp.charAt(i) == temp.charAt(index))
            {
                ls[i++] = index + 1;
                index++;
            }
            else
            {
                if(index != 0)
                {
                    index = ls[index - 1];
                }
                else
                {
                    index = 0;
                    i++;
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {

        String s = "acae";
        shortPal sp = new shortPal();

        String result = sp.getShortPal(s);

        System.out.println(result);
    }
}
