public class noOfBits {

        //Hamming distance
        // you need to treat n as an unsigned value
        public int hammingWeight(int x,int y) {

            int out = x^y;
            int res = 0;
            while(out  != 0)
            {
                res =  res + (out & 1);
                out = out >> 1;
            }

            return res;
        }

    public static void main(String[] args) {
        int x = 5;
        int y = 4;
        noOfBits nb =  new noOfBits();
        int n = nb.hammingWeight(x,y);
       System.out.println(n);
    }

}
