public class mergeSort {




    public void sort(int[] m,int low,int high)
    {

    }


    public void merge(int[] m,int low,int mid,int high)
    {
        int lh = mid-low+1;
        int rh = high-mid;

        int[] l = new int[lh];
        int[] r  = new int[rh];

        for(int i=0;i<l.length;i++)
        {
            l[i] = m[low+i];
        }
    }


    public void printArray(int[] arr)
    {
        for(int a:arr)
        {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        int[] m = {10,12,3,4,8,9,7};

        mergeSort s = new mergeSort();
        int n = m.length;
        s.sort(m,0,n-1);

        s.printArray(m);
    }
}
