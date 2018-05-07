public class longSubSequence {


    public int calLongSub(int[] arr )
    {
        int[] dp = new int[arr.length];

        int max = 0;
        for(int i=0;i<arr.length;i++)
        {
            dp[i] = 1;
        }

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i] > arr[j] && dp[j]+1 > dp[i])
                {
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max,dp[i]);
        }

        int maxIndex = 0;

        for(int i=0;i<dp.length;i++)
        {
            if(dp[i] > dp[maxIndex])
            {
                maxIndex = i;
            }
        }

        System.out.println(maxIndex);




        //lets print the actual solution
        /*int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();*/


        return max;

    }

    public static void main(String[] args) {

        longSubSequence lis = new longSubSequence();
        int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        int result = lis.calLongSub(arr);
        System.out.println(result);
    }
}

