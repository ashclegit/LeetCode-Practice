public class revNumber {

    public int numRev(int num)
    {
        int revNum = 0;

        while(num != 0)
        {
            revNum = revNum * 10;
            revNum = revNum + num%10;
            num = num/10;
        }
        return revNum;
    }

    public static void main(String[] args) {

        revNumber rv = new revNumber();
        int number = 123;
        int res = rv.numRev(number);
        System.out.println(res);
    }
}
