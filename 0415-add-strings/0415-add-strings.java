class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        String res = "";
        int i = n - 1;
        int j = m - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int ival = i >= 0 ? num1.charAt(i) - '0' : 0;
            int jval = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = ival + jval + carry;
            res = (sum % 10) + res;
            carry = sum / 10;
            i--;
            j--;
        }
        return res;
    }
}