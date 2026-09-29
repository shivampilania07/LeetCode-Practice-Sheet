class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,n);
    }

    public int solve(int i,String s,int n){
        if(i == n){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int result = solve(i+1,s,n);


        if(i+1<n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))){
            result += solve(i+2,s,n);
        }

        return dp[i] = result;
    }
}