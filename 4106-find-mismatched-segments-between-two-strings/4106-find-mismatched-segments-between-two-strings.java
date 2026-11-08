
class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        List<List<String>> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n) {
            List<String> temp = new ArrayList<>();

            // Skip matching characters
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
                continue;
            }

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            // Collect consecutive mismatching characters
            while (i < n && s1.charAt(i) != s2.charAt(j)) {
                sb1.append(s1.charAt(i));
                sb2.append(s2.charAt(j));

                i++;
                j++;
            }

            temp.add(sb1.toString());
            temp.add(sb2.toString());

            ans.add(temp);
        }

        return ans;
    }
}
