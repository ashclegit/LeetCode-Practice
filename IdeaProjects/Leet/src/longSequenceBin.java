public class longSequenceBin {



    public int calLongSub(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int len = 0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] > dp[len])
            {
                dp[++len] = arr[i];
            }
            else
            {
                int index = binSearch(dp,len,arr[i]);
                dp[index] = arr[i];
            }

        }
        return len+1;

    }

    public int binSearch(int[] dp,int len,int val)
    {

        int start = 0;
        while(start <= len)
        {
            int mid = start + (len - start)/2;

            if(dp[mid] == val)
            {
                return mid;
            }
            else if(dp[mid] > val)
            {
                len = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }

        return start;
    }



    public static void main(String[] args) {

        longSequenceBin lis = new longSequenceBin();
        int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        int result = lis.calLongSub(arr);
        System.out.println(result);

    }
}
