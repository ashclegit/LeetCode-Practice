import java.util.ArrayList;
import java.util.Arrays;

public class leetClass {


    public boolean palindrome(String s)
    {

        int j = s.length() - 1;

        for (int k=0 ; k<j ; ++k)
        {
            if(s[k++] == s[])
        }

        StringBuffer sb = new StringBuffer();

    }

    public List<List<Integer>> threeSum(int[] arr)
    {
        List<List<Integer>> resArray = ArrayList<>();
        Arrays.sort(arr);

        for(int i=0;i<arr.length-2;++i)
        {
            int l=i+1,r=arr.length -1;
            while(l<r)
            {
                if(arr[i]+arr[l]+arr[r] == 0)
                {
                    resArray.add(Arrays.asList(arr[i],arr[l],arr[r]));
                    l++;
                    r++;
                }
                else if(arr[i]+arr[l]+arr[r] > 0)
                {
                    r--;
                }
                else
                {
                    l++;
                }
            }

        }

    }



    public static void main(String[] args)
    {

    }
}
