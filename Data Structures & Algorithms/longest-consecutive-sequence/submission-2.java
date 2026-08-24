class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        // Hash
        HashSet<Integer> hash = new HashSet<>();
        for(int num: nums) {
            hash.add(num);
        }
        // Check if the number is starting of a sequence
        for(int num: nums) {
            if(!hash.contains(num-1)) {
                // If yes check all the numbers until length
                int length = 1;
                while(hash.contains(++num)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
            
            }
}
