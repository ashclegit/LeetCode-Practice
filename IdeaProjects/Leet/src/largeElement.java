public class largeElement {


    public int kthLargest(int[] arr,int k,int left,int right)
    {

        int low = left;
        int high = right;


        while(true)
        {
            int pi = partition(arr,low,high);

            if(pi==k)
            {
                return arr[k];
            }
            else if(pi < k)
            {
                low = pi+1;
            }
            else
            {
                high = pi-1;
            }
        }

        /*if(low<=high)
        {
            int pi = partition(arr,low,high);

            if(pi==k)
            {
                return arr[k];
            }
            else if(pi>k)
            {
                return kthLargest(arr,k,low,pi-1);
            }
            else
            {
                return kthLargest(arr,k,pi+1,high);
            }
        }*/

    }


    public int partition(int[] arr,int low,int high)
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

        while(low<high)
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

    public void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] array = {10,80,30,90,40,50,70};
        largeElement l = new largeElement();
        int n=array.length -1;
        int k=4;
        k = array.length-k;
        System.out.println(l.kthLargest(array,k,0,n));


    }
}
