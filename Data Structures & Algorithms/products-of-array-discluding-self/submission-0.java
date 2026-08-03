class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] suffix = new int[n];
        int prefix = 1; 

        for(int i=n-1;i>=0;i--) {
            if(i == n-1) suffix[i] = nums[i];
            else suffix[i] = suffix[i+1] * nums[i]; 
        }

        for (int i=0;i<n;i++) {
            if(i == n-1) suffix[i] = prefix;
            else suffix[i] = suffix[i+1] * prefix;
            prefix *= nums[i];
        }
        return suffix;
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
}  
