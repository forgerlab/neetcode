class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i1=0,i2=numbers.length-1;
        while(i1<i2) {
            int currSum = numbers[i1]+numbers[i2];
            if(currSum == target) {
                return new int[]{i1+1, i2+1};
            } else if(currSum > target) {
                i2--;
            } else i1++;
        }
        return new int[0];
    }
}
