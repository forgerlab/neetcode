class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String str: strs) {
            encodedString.append(str.length());
             encodedString.append("#");
            encodedString.append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        int i=0;

        while (i < str.length()) {
            StringBuilder len = new StringBuilder();
            while (str.charAt(i) != '#') {
                len.append(str.charAt(i++));
            }

            int strLen = Integer.parseInt(len.toString());

            String decodedStr = str.substring(i+1, i+strLen+1);
            decodedStrs.add(decodedStr);
            i += strLen+1;
        }
        return decodedStrs;
    }
}
