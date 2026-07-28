class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xorr = 0;
        for(int num : nums){
            xorr^=num;
        }
        int rightmost = (xorr & -xorr )&xorr;
        int b1 = 0;
        int b2 = 0;
        for(int i = 0;i<n;i++){
            if((nums[i]&rightmost) != 0){
                b1 = b1 ^nums[i];
            }else{
                b2 = b2^nums[i];
            }
        }
        return new int[]{b1,b2};
    }
}