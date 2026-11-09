class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();
        long ans = 0;
        int a = -1;
        int b = -1;
        int c = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                a = i;
            } else if (s.charAt(i) == 'b') {
                b = a;
            } else {
                c = b;
            }
            int len = i - c;
            ans += len;
        }
        return ans;
    }
}