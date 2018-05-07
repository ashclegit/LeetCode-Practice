import java.util.Arrays;

public class binarySearch {





    public boolean search(int[] arr,int k,int n)
    {
        int low = 0;
        int high = arr.length-1;
        while(low <= high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid] == k)
            {
                return true;
            }
            else if(arr[mid] < k)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int arr[] = {10, 7, 8, 9, 1, 5};
        Arrays.sort(arr);
        int n=arr.length;
        binarySearch b = new binarySearch();
        boolean res = b.search(arr,5,n);
        System.out.println(res);
    }
}


