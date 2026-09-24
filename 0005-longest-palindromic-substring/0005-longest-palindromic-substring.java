class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int maxLen = 0;
        String ans = "";
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = j; i < n; i++) {
                sb.append(s.charAt(i));
                if (isPalindrome(sb.toString())) {
                    if (sb.length() > maxLen) {
                        maxLen = sb.length();
                        ans = sb.toString();
                    }
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int st = 0;
        int e = n-1;
        while (st < e) {
            if (s.charAt(st) != s.charAt(e)) {
                return false;
            }
            st++;
            e--;
        }
        return true;
    }
}