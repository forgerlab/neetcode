class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Bucket array:
        // Index = frequency
        // Value = list of numbers having that frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // Stores: number -> frequency
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Result array
        int[] result = new int[k];

        // ---------------- Step 1: Count frequency ----------------
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // ---------------- Step 2: Fill buckets ----------------
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            int number = entry.getKey();
            int frequency = entry.getValue();

            // Create bucket if it doesn't exist
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            // Add number to its frequency bucket
            bucket[frequency].add(number);
        }

        // ---------------- Step 3: Collect Top K ----------------
        int index = 0;

        // Traverse from highest possible frequency to lowest
        for (int frequency = bucket.length - 1;
             frequency > 0 && index < k; // itr > 0 & index stops when k ele are found
             frequency--) {

            // Skip empty buckets
            if (bucket[frequency] == null) {
                continue;
            }

            // Add every number present in this frequency bucket
            for (int number : bucket[frequency]) {
                result[index++] = number;
                // Stop once K elements are collected
                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}