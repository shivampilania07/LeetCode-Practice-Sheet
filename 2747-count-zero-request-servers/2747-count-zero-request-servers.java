class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        Map<Integer, Integer> map = new HashMap<>(); //stores frequency of server's
        int left = 0;
        int right = 0;

        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < m; i++) {
            int start = q[i][0] - x;
            int end = q[i][0];

            //expand
            while (right < logs.length && logs[right][1] <= end) {
                int serverid = logs[right][0];
                map.put(serverid, map.getOrDefault(serverid, 0) + 1);
                right++;
            }

            //shrink
            while (left < right && logs[left][1] < start) {
                int serverid = logs[left][0];
                map.put(serverid, map.get(serverid) - 1);
                if (map.get(serverid) == 0) {
                    map.remove(serverid);
                }
                left++;
            }

            ans[q[i][1]] = n - map.size();
        }

        return ans;
    }
}