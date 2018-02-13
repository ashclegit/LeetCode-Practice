public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j=-1,i=0;
        for ( i=0;i<nums.length;++i)
        {
            if(nums[i] != 0)
            {
                swap(++j,i,nums);
            }
        }
    }

    public void swap(int a,int b, int[] nums)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
