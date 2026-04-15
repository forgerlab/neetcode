class Solution {
   public int rob(int[] nums) {
    int n = nums.length;

    // Edge case: no houses
    if (n == 0) return 0;

    // Edge case: only one house
    if (n == 1) return nums[0];

    // Since first and last are adjacent, solve two cases:
    // 1. Include first, exclude last
    // 2. Exclude first, include last
    return Math.max(
        robUtil(nums, 0, n - 2),
        robUtil(nums, 1, n - 1)
    );
}

private int robUtil(int[] nums, int start, int end) {
    // If only one house in this range
    if (start == end) return nums[start];

    // prevTwo → dp[i-2] → best till previous-previous house
    int prevTwo = nums[start];

    // prevOne → dp[i-1] → best till previous house
    int prevOne = Math.max(nums[start], nums[start + 1]);

    // Iterate from third element in range
    for (int i = start + 2; i <= end; i++) {

        // Option 1: skip current → prevOne
        // Option 2: pick current → nums[i] + prevTwo
        int current = Math.max(prevOne, nums[i] + prevTwo);

        // Shift window forward
        prevTwo = prevOne;
        prevOne = current;
    }

    // Final answer for this range
    return prevOne;
}

}
