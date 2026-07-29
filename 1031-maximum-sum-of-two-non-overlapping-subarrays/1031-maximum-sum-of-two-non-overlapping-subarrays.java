class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];

        
        for(int i = 0;i<n;i++){
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }

        int maxLval = 0;
        int ans = 0;
        for(int i = firstLen;i<=n-secondLen;i++){
            maxLval = Math.max(maxLval,prefixSum[i]-prefixSum[i-firstLen]);
            int currVal = prefixSum[i+secondLen]-prefixSum[i];
            ans = Math.max(ans,maxLval+currVal);
        }

        int maxRval =0;
        int ans1 = 0;
        for(int i = secondLen;i<=n-firstLen;i++){
            maxRval = Math.max(maxRval,prefixSum[i]-prefixSum[i-secondLen]);
            int currVal = prefixSum[i+firstLen]-prefixSum[i];
            ans1=Math.max(ans1,maxRval+currVal);
        }

        return Math.max(ans,ans1);
    }
}