class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] preMax = new int[n];
        preMax[0] = nums[0];
        
        for(int i = 1;i<n;i++){
            preMax[i] = Math.max(nums[i],preMax[i-1]);
        }

        int[] preMin = new int[n];
        preMin[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            preMin[i] = Math.min(nums[i],preMin[i+1]);
        }  

        for(int i = 0;i<n;i++){
            int score = preMax[i] - preMin[i];
            if(score<=k){
                return i;
            }
        }
        return -1;
    }
}