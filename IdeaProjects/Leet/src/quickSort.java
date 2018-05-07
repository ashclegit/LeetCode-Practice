public class quickSort {



    public void sort(int[] arr,int low,int high)
    {
        if(low <= high)
        {
            int partition  = partition(arr,low,high);
            sort(arr,low,partition-1);
            sort(arr,partition+1,high);
        }
    }


    public int partition(int[] arr,int low,int high)
    {
        int j  = low-1;
        //int i = 0;
        int pivot = arr[high];

        while(low < high)
        {
            if(arr[low] <= pivot)
            {
                //swap(,j,arr);
            }
        }

        swap(low+1,high,arr);
        return low+1;
    }

    public void swap(int i,int j,int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public void printArray(int[] arr)
    {
        for(int a:arr)
        {
            System.out.println(a);
        }
    }




    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort ob = new quickSort();
        //int res = ob.kthLargest(arr,3);
        //System.out.println(res);
        ob.sort(arr, 0, n-1);

        //System.out.println("sorted array");
        ob.printArray(arr);

    }


     /*public int partition(int[] arr,int low,int high)
    {
        int i = (low-1);
        int pivot = arr[high];

        /*for(int j=low;j<=high-1;j++)
        {
            if(arr[j] <= pivot)
            {
                i++;
                swap(arr,i,j);
            }
        }*/

      /*  while(low<high)
        {
            if(arr[low] <= pivot)
            {
                i++;
                swap(arr,i,low);
            }
            low++;
        }
        swap(arr,i+1,high);
        return (i+1);
    }

    /*public void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }*/



   /* public void sort(int[] arr,int low,int high)
    {
        if(low<=high)
        {
            int pi = partition(arr,low,high);

            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }
    }*/
}
