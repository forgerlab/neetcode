class Solution {
    public boolean isPalindrome(String s) {

        int i=0,j=s.length()-1;

        while (i<=j) {

            if(Character.isLetterOrDigit(s.charAt(i)) &&
                Character.isLetterOrDigit(s.charAt(j)) &&
                Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
            else if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            else {
                i++; j--;
            }
        }
        return true;
    }
}
