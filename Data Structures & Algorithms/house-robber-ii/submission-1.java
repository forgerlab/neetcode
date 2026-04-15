class Solution {
   public int rob(int[] nums) {
        int n = nums.length;
        if(n < 1) return 0;
        if(n == 1) return nums[0];
        return Math.max(robUtil(nums, 0, n-2), robUtil(nums, 1, n-1));
    }

    private int robUtil(int[] nums, int start, int end) {
        if(start == end) return nums[start];
        int prev1 = nums[start];
        int prev2 = Math.max(nums[start], nums[start+1]);
        for(int i=start+2;i<=end;i++) {
            int result = Math.max(prev2, nums[i] + prev1);
            prev1 = prev2;
            prev2 = result;
        }
        return prev2;
    }

}
