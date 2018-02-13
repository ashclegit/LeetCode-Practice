public class trapWater {

    public int trap(int[] height) {

        int low = 0;
        int high = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while(low <= high)
        {
            if(height[low] < height[high])
            {
                if(height[low] > leftMax)
                {
                    leftMax = height[low];
                }
                else
                {
                    result = result + leftMax - height[low];
                    low++;
                }
            }
            else
            {
                if(height[high] > rightMax)
                {
                    rightMax = height[high];
                }
                else
                {
                    result = result + rightMax - height[high];
                    high--;
                }
            }

        }
        return result;
    }
}
