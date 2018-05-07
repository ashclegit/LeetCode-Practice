public class searchRotated {


    public int search(int[] arr, int k)
    {
        int low = 0;
        int high = arr.length-1;

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[mid] == k) return mid;

            if(arr[mid] <= arr[high])
            {
                if(k>arr[mid] && arr[high]>=k)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            else
            {
                if(arr[low]<=k && k<arr[mid])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,1,2,3};
        int k = 1;
        searchRotated s = new searchRotated();

        int i = s.search(arr,k);
        System.out.println("the index is: " + i);

    }
}
