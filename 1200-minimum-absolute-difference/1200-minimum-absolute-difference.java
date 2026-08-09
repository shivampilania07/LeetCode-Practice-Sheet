class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int mini = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i-1];
            mini = Math.min(mini,diff);
        }
        int i = 0;
        int j = 1;
        while (j < n) {
            List<Integer> temp = new ArrayList<>();
            if (Math.abs(arr[j] - arr[i]) == mini) {
                temp.add(arr[i]);
                temp.add(arr[j]);
                ans.add(temp);
            }
            i++;
            j++;
        }
        return ans;
    }
}