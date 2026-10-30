class Solution {
    int m,n;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }

        dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(obstacleGrid,m,n,0,0);
    }

    public int solve(int[][] obstacleGrid,int m,int n,int i,int j){
        if(i == m-1 && j == n-1){
            return 1;
        }

        if(obstacleGrid[i][j] == 1){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int bottom = 0;
        if(i+1<m){
            bottom = solve(obstacleGrid,m,n,i+1,j);
        }

        int right = 0;
        if(j+1<n){
            right = solve(obstacleGrid,m,n,i,j+1);
        }

        return dp[i][j] = bottom + right;
    }
}