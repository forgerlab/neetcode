class Solution {
    public int longestConsecutive(int[] nums) {
        int MAX = 0;
        // Hash
        HashSet<Integer> hash = new HashSet<>();
        for(int num: nums) {
            hash.add(num);
        }
        // Check if the number is starting of a sequence
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            if(!hash.contains(num-1)) {
                // If yes check all the numbers until length
                int length = 1;
                while(hash.contains(++num)) {
                    length++;
                }
                MAX = Math.max(MAX, length);
            }
        }
        return MAX;
            
            }
}
