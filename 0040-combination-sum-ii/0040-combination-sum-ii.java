class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        int n = candidates.length;
        solve(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public void solve(int[] arr, int target, int ind, List<List<Integer>> ans, ArrayList<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) { // prevent from duplicates
                continue;
            }
            if (arr[i] > target)
                break; //if element is greater than target

            //Pick
            ds.add(arr[i]);
            solve(arr, target-arr[i], i + 1, ans, ds);
            //backtrack
            ds.remove(ds.size() - 1);
        }
    }
}