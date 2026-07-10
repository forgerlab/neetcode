class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String str: strs) {
            ArrayList<Integer> charOcc = new ArrayList<>(Collections.nCopies(26, 0));
            for(char ch: str.toCharArray()) {
                charOcc.set(ch - 'a', charOcc.get(ch - 'a') + 1);
            }
            if(map.get(charOcc) == null) {
                map.put(charOcc, new ArrayList<>(Arrays.asList(str)));
            } else {
                map.get(charOcc).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
