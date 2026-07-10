class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

// Generate frequency of characters of a string
// Keep that as a key in hashmap
// Tip: Instead of storing list, you can convert list to a string
        for (String str: strs) {
            ArrayList<Integer> charOcc = new ArrayList<>(Collections.nCopies(26, 0));
            for(char ch: str.toCharArray()) {
                charOcc.set(ch - 'a', charOcc.get(ch - 'a')+1); // Increase ascii value/frequency
            }
            String key = charOcc.toString(); // convert to string and store as a key
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
