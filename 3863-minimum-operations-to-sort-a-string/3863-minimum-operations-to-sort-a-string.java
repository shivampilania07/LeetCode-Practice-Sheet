class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sort = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sort = false;
                break;
            }
        }

        if (s.length() == 2) {
            if (s.charAt(0) > s.charAt(1)) {
                return -1;
            } else {
                return 0;
            }
        }

        if (sort) {
            return 0;
        }

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char smallest = map.firstKey();
        char largest = map.lastKey();

        if (s.charAt(0) == smallest || s.charAt(n - 1) == largest) {
            return 1;
        }

        if (map.get(smallest) == 1 && map.get(largest) == 1 && s.charAt(0) == largest && s.charAt(n - 1) == smallest) {
            return 3;
        } //yeh sabse important...

        return 2;
    }
}

//Way 1 :- 
//sabse pahle ik map lenge phir usmain store karenge string ke har ik element ko then on the basis of that ham string m check karenge
//case 1: already sorted -- return 0;
//case 2: agar map ka first element and string ka first element same h ya phir map ka last element and string ka last element same h toh ham --- return 1;
//case 3: agar map ka first element ki freq 1 h or map last element ki freq bhi 1 h tabh ham yeh karenge ki or first and last element interchange h yani smallest element string ke last m h or largest element string ke first m h tabh --- return 3;
//and otherwise return 2;
// ik or condition lagegi jabh sirf ba honge mtlb two element honge or first greatest hoga second se tabh return -1;