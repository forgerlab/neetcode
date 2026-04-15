class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n < 1) return 0;
        if(n == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++) {
            nums[i] = Math.max(nums[i-1], nums[i] + nums[i-2]); 
            // Consider same array as dp[i]
            // nums[i-1] == skip current element & pick max till now
            // nums[i] + nums[i-1] == pick current element & skip max till now
        }
        return nums[nums.length-1];
    }
}
