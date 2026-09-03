class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int smallestodd = Integer.MAX_VALUE;
        int smallesteven = Integer.MAX_VALUE;
        boolean checkeven = true;
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 != 0) {
                checkeven = false;
            }
        }
        if (checkeven)
            return true;

        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 != 0) {
                smallestodd = Math.min(smallestodd, nums1[i]);
            }

            if (nums1[i] % 2 == 0) {
                smallesteven = Math.min(smallesteven, nums1[i]);
            }
        }

        if (smallestodd > smallesteven) {
            return false;
        } else {
            return true;
        }
    }
}