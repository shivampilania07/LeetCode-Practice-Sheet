class Solution {
    public class Worker {
        int quality;
        int wage;
        double ratio;

        Worker(int q, int w) {
            quality = q;
            wage = w;
            ratio = (double) w / q;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];

        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int qualitySum = 0;
        double ans = Double.MAX_VALUE;

        for (Worker w : workers) {
            pq.offer(w.quality);
            qualitySum += w.quality;

            if (pq.size() > k) {
                qualitySum -= pq.poll();
            }
            if (pq.size() == k) {
                ans = Math.min(ans, qualitySum * w.ratio);
            }
        }
        return ans;
    }
}