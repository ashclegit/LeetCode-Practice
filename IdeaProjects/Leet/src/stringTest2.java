public class stringTest2 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        int i = 10;
        int j = 8;

        sb.append(i+" ");
        sb.append(j+" ");

        String newString = sb.toString();
        String[] values = newString.split(" ");


        for(int k=0;k<values.length;k++)
        {
            System.out.print(values[k]);
        }

        String testWord = "ashwin";
        char[] testArray = testWord.toCharArray();

        char c = testArray[0];



        System.out.println(c - 'a');



    }
}
