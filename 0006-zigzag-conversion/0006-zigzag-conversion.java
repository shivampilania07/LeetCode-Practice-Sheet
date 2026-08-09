class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(numRows == 1){
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            int idx = i;
            int down = 2 * (numRows - 1 - i);
            int up = 2 * i;
            boolean goingSouth = true;

            while (idx < s.length()) {
                sb.append(s.charAt(idx));

                    if (i == 0) {
                    idx += down;
                }
                else if (i == numRows - 1) {
                    idx += up;
                }
                else {
                    if (goingSouth) {
                        idx += down;
                    } else {
                        idx += up;
                    }
                    goingSouth = !goingSouth;
                }
            }
        }

        return sb.toString();
    }
}