class Solution {
    public int smallestNumber(int n, int t) {
        int prod = 1;
        for(int i = n;i<100;i++){
            if(prodt(i)%t==0){
                return i;
            }
        }
        return 100;
    }

    public int prodt(int n){
        int prod = 1;
        while(n>0){
            int r = n%10;
            prod*=r;
            n/=10;
        }
        return prod;
    }
}