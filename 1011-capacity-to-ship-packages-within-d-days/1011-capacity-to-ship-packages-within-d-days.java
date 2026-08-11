class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0;i<n;i++){
            low = Math.max(low,weights[i]);
            high +=weights[i];
        }
        int ans = high;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isPossible(weights,days,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] weights,int days,int mid){
        int n = weights.length;
        int dayDone = 1;
        int load = 0;
        for(int i = 0;i<n;i++){
            if(load+weights[i]>mid){
                dayDone++;
                load = weights[i];
            }else{
                load+=weights[i];
            }
        }
        return dayDone<=days;
    }
}